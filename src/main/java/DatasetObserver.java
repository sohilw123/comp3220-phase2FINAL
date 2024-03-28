/**
 * An interface for objects that observe changes in datasets.
 */
public interface DatasetObserver {
    /**
     * Called to notify the observer about an update in the dataset.
     */
    void update();
}
