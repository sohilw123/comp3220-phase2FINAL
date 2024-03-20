import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Data {

    private String sourcePath = "src/main/resources/datasets/";
    private ArrayList<String> fields;
    private ArrayList<DataInfo> data;
    Dataset dataset;

    public Data(Dataset dataset) {
        this.dataset = dataset;
        sourcePath += dataset.getSource();
        fields = new ArrayList<>();
        data = new ArrayList<>();
        readFromCSV();
    }

    private void readFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(sourcePath))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                String[] readData = line.split(",");
                if (firstLine) {
                    firstLine = false;
                    Collections.addAll(fields, readData);
                } else {
                    DataInfo dataToAdd = new DataInfo();
                    dataToAdd.addData(readData);
                    data.add(dataToAdd);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder allData = new StringBuilder();
        for (String field : fields) {
            allData.append(field).append("\t|\t");
        }
        allData.append("\n");
        for (DataInfo dataInfo : data) {
            allData.append(dataInfo.toString());
            allData.append("\n");
        }
        return allData.toString();
    }
}

class DataInfo {
    private final ArrayList<String> dataInfo;

    public DataInfo() {
        dataInfo = new ArrayList<>();
    }

    public void addData(String[] data) {
        Collections.addAll(dataInfo, data);
    }

    @Override
    public String toString() {
        StringBuilder dataRow = new StringBuilder();
        for (String data : dataInfo) {
            dataRow.append(data).append("\t|\t");
        }
        return dataRow.toString();
    }
}
