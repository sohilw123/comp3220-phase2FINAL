import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatasetManager {
  private List<DatasetObserver> observers = new ArrayList<>();
  private final List<Dataset> datasets;
  private final String CSV_FILE_PATH = "src/main/resources/datasets.csv"; // Path to the CSV file

  // Constructor
  public DatasetManager() {
    this.datasets = new ArrayList<>();
    loadFromCSV(); // Load datasets from CSV file on initialization
  }

  // Method to add a dataset to both the list and CSV file
  public Dataset addDataset(Dataset dataset) {
    datasets.add(dataset);
    writeToCSV();
    return dataset;
  }

  // Method to update a dataset in both the list and CSV file
  public Dataset updateDataset(Dataset dataset) {
    for (int i = 0; i < datasets.size(); i++) {
      if (datasets.get(i).getName().equals(dataset.getName())) {
        datasets.set(i, dataset);
        break;
      }
    }
    writeToCSV();
    return dataset;
  }

  //Method to find a dataset by name
  public Dataset findDatasetByName(String name) {
    for (Dataset dataset : datasets) {
      if (dataset.getName().equals(name)) {
        return dataset;
      }
    }
    return null; // Dataset not found
  }

  // Method to delete a dataset from both the list and CSV file
  public void deleteDataset(Dataset dataset) {
    datasets.remove(dataset);
    writeToCSV();
  }

  public void printDatasets() {
      for (Dataset dataset : datasets) {
          System.out.println(dataset);
      }
  }

  // Method to load datasets from CSV file
  private void loadFromCSV() {
    try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] data = line.split(",");
        String name = data[0];
        String description = data[1];
        String source = data[2];
        // Frequency updateFrequency = Frequency.valueOf(data[4]);
        datasets.add(new Dataset(name, description, source));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Method to write datasets to CSV file
  private void writeToCSV() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
      for (Dataset dataset : datasets) {
        StringBuilder sb = new StringBuilder();
        sb.append(dataset.getName()).append(",");
        sb.append(dataset.getDescription()).append(",");
        sb.append(dataset.getSource()).append("\n");
        // sb.append(dataset.getUpdateFrequency()).append("\n");
        bw.write(sb.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Method to add observers
  public void addObserver(DatasetObserver observer) {
    observers.add(observer);
  }

  // Method to notify observers about changes in datasets
  public void notifyObservers() {
    for (DatasetObserver observer : observers) {
      observer.update();
    }
  }
}
