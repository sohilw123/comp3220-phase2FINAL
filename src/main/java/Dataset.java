/**
 * Represents a dataset.
 */
public class Dataset {
  private String name;
  private String description;
  private String source;
  // private Frequency updateFrequency;

  /**
   * Constructs a Dataset object.
   *
   * @param name        The name of the dataset.
   * @param description The description of the dataset.
   * @param source      The source of the dataset.
   */
  public Dataset(String name, String description, String source) {
    this.name = name;
    this.description = description;
    this.source = source;
    // this.updateFrequency = updateFrequency;
  }

  /**
   * Parses dataset from CSV format.
   *
   * @param csvLine The CSV line representing the dataset.
   * @return The Dataset object parsed from the CSV line.
   */
  public static Dataset fromCSV(String csvLine) {
    String[] data = csvLine.split(",");
    String name = data[0];
    String description = data[1];
    String source = data[2];
    // Frequency updateFrequency = Frequency.valueOf(data[4]);
    return new Dataset(name, description, source);
  }

  /**
   * Converts dataset to CSV format.
   *
   * @return The CSV representation of the dataset.
   */
  public String toCSV() {
      return name + "," +
            description + "," +
            source + "," +
            "placeholder";
  }

  /**
   * Generates a string representation of the dataset.
   *
   * @return The string representation of the dataset.
   */
  @Override
  public String toString() {
    return "Dataset{" +
            "name: " + name +
            ", description: " + description +
            ", source: " + source +
            '}';
  }

  // Getter and setter methods

  /**
   * Retrieves the name of the dataset.
   *
   * @return The name of the dataset.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the dataset.
   *
   * @param name The name to set for the dataset.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Retrieves the description of the dataset.
   *
   * @return The description of the dataset.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description of the dataset.
   *
   * @param description The description to set for the dataset.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Retrieves the source of the dataset.
   *
   * @return The source of the dataset.
   */
  public String getSource() {
    return source;
  }

  /**
   * Sets the source of the dataset.
   *
   * @param source The source to set for the dataset.
   */
  public void setSource(String source) {
    this.source = source;
  }

//  public Frequency getUpdateFrequency() {
//    return updateFrequency;
//  }
//
//  public void setUpdateFrequency(Frequency updateFrequency) {
//    this.updateFrequency = updateFrequency;
//  }
}
