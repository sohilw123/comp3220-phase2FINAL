import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages datasets, including adding, updating, and deleting datasets, as well as loading and writing datasets to CSV files.
 */
public class DatasetManager {
  private List<DatasetObserver> observers = new ArrayList<>();
  private final List<Dataset> datasets;
  private final String CSV_FILE_PATH = "src/main/resources/datasets.csv"; // Path to the CSV file

  /**
   * Constructs a DatasetManager object.
   * Initializes the list of datasets and loads datasets from the CSV file.
   */
  public DatasetManager() {
    this.datasets = new ArrayList<>();
    loadFromCSV(); // Load datasets from CSV file on initialization
  }

  /**
   * Adds a dataset to both the list and CSV file.
   *
   * @param dataset The dataset to add.
   * @return The added dataset.
   */
  public Dataset addDataset(Dataset dataset) {
    datasets.add(dataset);
    writeToCSV();
    return dataset;
  }

  /**
   * Updates a dataset in both the list and CSV file.
   *
   * @param dataset The dataset to update.
   * @return The updated dataset.
   */
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

  /**
   * Finds a dataset by name.
   *
   * @param name The name of the dataset to find.
   * @return The found dataset, or null if not found.
   */
  public Dataset findDatasetByName(String name) {
    for (Dataset dataset : datasets) {
      if (dataset.getName().equals(name)) {
        return dataset;
      }
    }
    return null; // Dataset not found
  }

  /**
   * Deletes a dataset from both the list and CSV file.
   *
   * @param dataset The dataset to delete.
   */
  public void deleteDataset(Dataset dataset) {
    datasets.remove(dataset);
    writeToCSV();
  }

  /**
   * Prints all datasets.
   */
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

  /**
   * Adds an observer to the list of observers.
   *
   * @param observer The observer to add.
   */
  public void addObserver(DatasetObserver observer) {
    observers.add(observer);
  }

  /**
   * Notifies observers about changes in datasets.
   */
  public void notifyObservers() {
    for (DatasetObserver observer : observers) {
      observer.update();
    }
  }
}
