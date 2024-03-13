import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatasetManagerTest {

    DatasetManager datasetManager = new DatasetManager();
    Dataset testSet = new Dataset("Test Name", "Test description.", "test.csv");
    Dataset updatedTestSet = new Dataset("Test Name", "This is a new description.", "test.csv");

    @Test
    void addDataset() {
        assertAll(() -> assertEquals(testSet, datasetManager.addDataset(testSet)),
            () -> assertEquals(testSet, datasetManager.findDatasetByName("Test Name")));
    }

    @Test
    void updateDataset() {
        datasetManager.addDataset(testSet);
        assertAll(() -> assertEquals(updatedTestSet, datasetManager.updateDataset(updatedTestSet)),
                () -> assertEquals(updatedTestSet, datasetManager.findDatasetByName("Test Name")));
    }

    @Test
    void findDatasetByName() {
        datasetManager.addDataset(testSet);
        assertEquals(testSet, datasetManager.findDatasetByName("Test Name"));
    }

    @Test
    void deleteDataset() {
        datasetManager.addDataset(testSet);
        datasetManager.deleteDataset(testSet);
        assertNull(datasetManager.findDatasetByName("Test Name"));
    }
}