# Hospital-Management-System-Using-Java-Swing

HOSPITALMGTGUI is a hospital management system developed in Java that aims to streamline and automate key operations within a hospital setting. The system provides a user-friendly graphical interface built using Java Swing, enabling hospital staff to manage essential data like doctor details, patient records, billing, and staff information.

# Key Features:
- Interactive UI: A simple and intuitive interface for navigating through various hospital modules such as Doctors, Patients, Billing, and more.
- Dynamic Data Management: Allows users to add, edit, delete, and search hospital records with ease.
- Modular Architecture: Clear separation of different modules for easy extension and future modifications.
- In-memory Data Management: Data is temporarily stored in memory for the duration of the session. Future work includes integrating a database for data persistence.

# Technologies Used:
- Java: Core programming language used for system development.
- Java Swing: For creating the graphical user interface (GUI).
- JTable, JTextField, JButton: Key UI components used for dynamic interactions.
- TableRowSorter: For sorting and filtering data dynamically in tables.
- JOptionPane: For displaying user-friendly dialog boxes for interactions (e.g., errors, confirmations).

# Future Work:
- Database Integration: Implementing persistent data storage using a database for better data management and long-term usage.
- Scalability: Enhancing the system to handle larger amounts of data and more complex hospital operations.
- Improved Error Handling: Adding better validation and feedback mechanisms to improve user experience.
  
# Usage Instructions

1. **Clone the repository**:  
   Start by cloning the repository to your local machine using the following command:

2. **Set up the environment**:  
Ensure that you have **Java Development Kit (JDK)** installed on your system. The project is built using Java 8 or higher. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).

3. **Compile the project**:  
Open a terminal or command prompt and navigate to the project directory. Then, compile the Java files using the following command:


4. **Run the application**:  
After successful compilation, run the main class (`HOSPITALMGTGUI`) using the following command:


5. **Interacting with the application**:  
- Once the application is launched, the main menu will appear, displaying different sections such as **Doctor**, **Patient**, **Billing**, etc.
- Click on any button to open the corresponding section.
- In each section, you can **add**, **edit**, or **delete** entries using the buttons provided.
- Use the **search bar** to filter data in each section.
- Data is temporarily stored in memory for the current session, so the changes will be lost when the application is closed.

6. **Future Updates**:  
Currently, data persistence is not implemented, but future versions will include a database to store data permanently.
   
