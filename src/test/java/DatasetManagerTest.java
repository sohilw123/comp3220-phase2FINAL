import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatasetManagerTest {

    DatasetManager datasetManager = new DatasetManager();

    @Test
    void addDataset() {
        Dataset testSet = new Dataset("Test Name", "Test description.", new String[]{"Field 1", "Field 2", "Field 3"}, "Source");
        assertEquals(testSet, datasetManager.addDataset(testSet));
        assertEquals(testSet, datasetManager.findDatasetByName("Test Name"));
    }

    @Test
    void updateDataset() {

    }

    @Test
    void findDatasetByName() {
    }

    @Test
    void deleteDataset() {
    }
}