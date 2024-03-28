City Data Management System (CDMS)
Overview
The City Data Management System (CDMS) is a prototype developed to centralize and streamline data management processes for the City of Windsor. The system aims to provide easy access to government data, enhance transparency, and facilitate data-driven decision-making.

Project Structure
The project consists of several Java classes organized into packages:

Backend: Contains classes responsible for managing user authentication and dataset operations.
Data: Contains classes related to dataset management and data processing.
UsageStatistics: Contains classes for tracking and managing usage statistics.
Main: Contains the main class to run the CDMS program.
Interfaces: Contains interfaces used for defining observers and dataset operations.

Class Descriptions
Backend: This class handles user authentication and interacts with the dataset manager and usage statistics manager.
Data: The Data class manages dataset information, including loading datasets from CSV files and providing methods for dataset manipulation.
Dataset: Represents a dataset object, including its name, description, and source.
DatasetManager: Manages datasets, including adding, updating, and deleting datasets, as well as loading and writing dataset information to CSV files.
DatasetObserver: An interface implemented by classes that observe dataset changes.
Program: The main class responsible for starting the CDMS program and handling user interactions.
UsageStatisticsManager: Manages usage statistics, including tracking dataset usage and writing statistics to a CSV file.

How to Run
To run the CDMS prototype, follow these steps:

Compile all Java files in the project using a Java compiler.
Run the Main class from the command line or an IDE.
Dependencies
The CDMS prototype has no external dependencies and only requires a Java Runtime Environment (JRE) to run.

The City Data Management System (CDMS) comprises several interconnected classes that collaborate to facilitate efficient management, tracking, and utilization of datasets. At the core of the system lies the Program class, serving as the orchestrator of user interactions and system functionalities. Upon initialization, the Program class instantiates essential components such as the UsageStatisticsManager and Backend. Through a user-friendly interface and menu options, users can interact with the CDMS, accessing features like viewing datasets, adding, updating, or deleting datasets, and tracking dataset usage. These interactions are facilitated by the Backend class, acting as a mediator between the user interface and the dataset management system.
The Backend class utilizes instances of the DatasetManager and UsageStatisticsManager classes to manage datasets and track their usage, respectively. The DatasetManager class serves as the primary manager of datasets, maintaining a synchronized list of datasets and ensuring their persistence by managing interactions with a CSV file (datasets.csv). It offers functionalities for adding, updating, deleting, and retrieving datasets, ensuring seamless integration with the CDMS. Furthermore, the UsageStatisticsManager class is responsible for tracking and maintaining usage statistics for datasets. It implements the singleton pattern to ensure a single instance throughout the application, offering methods for tracking dataset usage and updating usage statistics accordingly. This class interacts with a CSV file (usage_statistics.csv) to persist usage statistics data across sessions.
Additionally, the CDMS includes the Dataset class, representing individual datasets within the system. This class encapsulates dataset attributes and provides methods for parsing datasets from and converting datasets to CSV format, facilitating data interchange within the system. Moreover, the DatasetObserver interface defines the contract for classes that observe changes in datasets. Implementing classes, such as the UsageStatisticsManager, can register as observers to receive notifications about dataset modifications, enabling real-time updates and synchronization of usage statistics.
Together, these interconnected classes and components form a robust and comprehensive system for managing datasets, tracking their usage, and facilitating user interactions within the CDMS. By leveraging these components, users can efficiently navigate and manipulate datasets, promoting effective data management and decision-making processes within the city.
