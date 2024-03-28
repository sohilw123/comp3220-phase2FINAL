import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents the backend functionality of the application.
 * This class handles user authentication and manages datasets and usage statistics.
 */
public class Backend {
    private DatasetManager datasetManager;
    private UsageStatisticsManager usageStatsManager;
    private final String USER_CREDENTIALS_FILE_PATH = "src/main/resources/users.csv"; // Path to the CSV file

    /**
     * Constructs a Backend object.
     * Initializes dataset manager, usage statistics manager, and observes changes in the dataset manager.
     * Creates a user credentials file if it doesn't exist.
     *
     * @param datasetManager    The DatasetManager object.
     * @param usageStatsManager The UsageStatisticsManager object.
     */
    public Backend(DatasetManager datasetManager, UsageStatisticsManager usageStatsManager) {
        this.datasetManager = datasetManager;
        this.usageStatsManager = usageStatsManager;
        datasetManager.addObserver(usageStatsManager);
        createIfNotExists(USER_CREDENTIALS_FILE_PATH); // Create user credentials file if not exists
    }

    /**
     * Authenticates a user based on provided username and password.
     *
     * @param username The username to authenticate.
     * @param password The password associated with the username.
     * @return True if authentication is successful, otherwise false.
     */
    public boolean authenticateUser(String username, String password) {
        Map<String, String> credentials = readUserCredentials();
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }

    /**
     * Reads user credentials from the CSV file.
     *
     * @return A map containing username-password pairs.
     */
    private Map<String, String> readUserCredentials() {
        Map<String, String> credentials = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USER_CREDENTIALS_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                credentials.put(data[0], data[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credentials;
    }

    /**
     * Creates a file if it does not exist.
     *
     * @param filePath The path of the file to create.
     */
    private void createIfNotExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Retrieves the DatasetManager object.
     *
     * @return The DatasetManager object.
     */
    public DatasetManager getDatasetManager() {
        return datasetManager;
    }

    /**
     * Retrieves the UsageStatisticsManager object.
     *
     * @return The UsageStatisticsManager object.
     */
    public UsageStatisticsManager getUsageStatisticsManager() {
        return usageStatsManager;
    }
}
