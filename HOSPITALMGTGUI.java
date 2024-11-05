import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class HOSPITALMGTGUI extends JFrame 
{
    private DefaultTableModel doctorTableModel;
    private DefaultTableModel patientTableModel;
    private DefaultTableModel inventoryTableModel;
    private DefaultTableModel labTableModel;
    private DefaultTableModel labOrdersTableModel;
    private DefaultTableModel facilityTableModel;
    private DefaultTableModel staffTableModel;
    private DefaultTableModel appointmentsTableModel;
    private DefaultTableModel opdTableModel;
    private DefaultTableModel ipdTableModel;
    private DefaultTableModel billingTableModel;

    public HOSPITALMGTGUI() 
    {
        setTitle("🌟MODI-MEDICARE: Comprehensive Hospital Management System🌟");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize data models with dummy data
        doctorTableModel = new DefaultTableModel(new String[]{"ID", "Name", "Specialist", "Work Time", "Qualification", "Room"}, 0);
        doctorTableModel.addRow(new String[]{"D1", "Dr. Purva", "Cardiologist", "9-5", "MBBS,MD", "101"});
        doctorTableModel.addRow(new String[]{"D2", "Dr. Brown", "Neurologist", "9-3", "MBBS,PhD", "102"});
        doctorTableModel.addRow(new String[]{"D3", "Dr. Lee", "Pediatrician", "10-4", "MBBS,MD", "103"});
        doctorTableModel.addRow(new String[]{"D4", "Dr. Patel", "Dermatologist", "9-5", "MBBS", "104"});
        doctorTableModel.addRow(new String[]{"D5", "Dr. Jones", "Surgeon", "8-6", "MBBS,MS", "105"});

        patientTableModel = new DefaultTableModel(new String[]{"ID", "Name", "Disease", "Sex", "Admit Status", "Age"}, 0);
        patientTableModel.addRow(new String[]{"P1", "John Doe", "Flu", "M", "Admitted", "34"});
        patientTableModel.addRow(new String[]{"P2", "Jane Doe", "Fever", "F", "Discharged", "29"});
        patientTableModel.addRow(new String[]{"P3", "Michael Brown", "Headache", "M", "Admitted", "45"});
        patientTableModel.addRow(new String[]{"P4", "Emily White", "Cold", "F", "Discharged", "22"});
        patientTableModel.addRow(new String[]{"P5", "Chris Green", "Cough", "M", "Admitted", "60"});

        inventoryTableModel = new DefaultTableModel(new String[]{"ID", "Name", "Type", "Quantity", "Price"}, 0);
        inventoryTableModel.addRow(new String[]{"M1", "Paracetamol", "Tablet", "100", "5"});
        inventoryTableModel.addRow(new String[]{"M2", "Aspirin", "Tablet", "50", "3"});
        inventoryTableModel.addRow(new String[]{"M3", "Amoxicillin", "Capsule", "80", "10"});
        inventoryTableModel.addRow(new String[]{"M4", "Ibuprofen", "Tablet", "150", "6"});
        inventoryTableModel.addRow(new String[]{"M5", "Lisinopril", "Tablet", "200", "8"});

        labTableModel = new DefaultTableModel(new String[]{"ID", "Test Name", "Cost", "Available"}, 0);
        labTableModel.addRow(new String[]{"L1", "Blood Test", "200", "Yes"});
        labTableModel.addRow(new String[]{"L2", "X-Ray", "500", "No"});
        labTableModel.addRow(new String[]{"L3", "MRI", "1500", "Yes"});
        labTableModel.addRow(new String[]{"L4", "CT Scan", "1200", "Yes"});
        labTableModel.addRow(new String[]{"L5", "Ultrasound", "800", "Yes"});

        labOrdersTableModel = new DefaultTableModel(new String[]{"Order ID", "Patient ID", "Test ID", "Order Date"}, 0);
        labOrdersTableModel.addRow(new String[]{"O1", "P1", "L1", "05-11-2024"});
        labOrdersTableModel.addRow(new String[]{"O2", "P2", "L2", "06-11-2024"});
        labOrdersTableModel.addRow(new String[]{"O3", "P3", "L3", "07-11-2024"});
        labOrdersTableModel.addRow(new String[]{"O4", "P4", "L4", "08-11-2024"});
        labOrdersTableModel.addRow(new String[]{"O5", "P5", "L5", "09-11-2024"});

        facilityTableModel = new DefaultTableModel(new String[]{"ID", "Facility Name", "Details"}, 0);
        facilityTableModel.addRow(new String[]{"F1", "ICU", "Intensive Care Unit"});
        facilityTableModel.addRow(new String[]{"F2", "ER", "Emergency Room"});
        facilityTableModel.addRow(new String[]{"F3", "Radiology", "Radiology Services"});
        facilityTableModel.addRow(new String[]{"F4", "Pharmacy", "Medicine Dispensing"});
        facilityTableModel.addRow(new String[]{"F5", "Surgery", "Operation Theatre"});

        staffTableModel = new DefaultTableModel(new String[]{"ID", "Name", "Position", "Salary"}, 0);
        staffTableModel.addRow(new String[]{"S1", "Alice", "Nurse", "5000"});
        staffTableModel.addRow(new String[]{"S2", "Bob", "Receptionist", "3000"});
	    staffTableModel.addRow(new String[]{"S3", "Charlie", "Administrator", "4000"});
        staffTableModel.addRow(new String[]{"S4", "Diana", "Pharmacist", "5200"});
        staffTableModel.addRow(new String[]{"S5", "Edward", "Lab Technician", "2500"});

        appointmentsTableModel = new DefaultTableModel(new String[]{"Patient ID", "Doctor ID", "Appointment Date", "Appointment Time"}, 0);
        appointmentsTableModel.addRow(new String[]{"P1", "D1", "05-11-2024", "02:30 PM"});
        appointmentsTableModel.addRow(new String[]{"P2", "D2", "06-11-2024", "10:00 AM"});
        appointmentsTableModel.addRow(new String[]{"P3", "D3", "07-11-2024", "11:00 AM"});
        appointmentsTableModel.addRow(new String[]{"P4", "D4", "08-11-2024", "01:00 PM"});
        appointmentsTableModel.addRow(new String[]{"P5", "D5", "09-11-2024", "03:00 PM"});

        opdTableModel = new DefaultTableModel(new String[]{"Patient ID", "Doctor ID", "Visit Date", "Status"}, 0);
        opdTableModel.addRow(new String[]{"P1", "D1", "01-11-2024", "Completed"});
        opdTableModel.addRow(new String[]{"P2", "D2", "02-11-2024", "Completed"});
        opdTableModel.addRow(new String[]{"P3", "D3", "03-11-2024", "In Progress"});
        opdTableModel.addRow(new String[]{"P4", "D4", "04-11-2024", "Pending"});
        opdTableModel.addRow(new String[]{"P5", "D5", "05-11-2024", "Completed"});

        ipdTableModel = new DefaultTableModel(new String[]{"Patient ID", "Doctor ID", "Admit Date", "Room", "Status"}, 0);
        ipdTableModel.addRow(new String[]{"P1", "D1", "01-11-2024", "101", "Admitted"});
        ipdTableModel.addRow(new String[]{"P2", "D2", "02-11-2024", "102", "Discharged"});
        ipdTableModel.addRow(new String[]{"P3", "D3", "03-11-2024", "103", "Admitted"});
        ipdTableModel.addRow(new String[]{"P4", "D4", "04-11-2024", "104", "Pending"});
        ipdTableModel.addRow(new String[]{"P5", "D5", "05-11-2024", "105", "Admitted"});

        billingTableModel = new DefaultTableModel(new String[]{"Bill ID", "Patient ID", "Total Amount", "Payment Status"}, 0);
        billingTableModel.addRow(new String[]{"B1", "P1", "250", "Paid"});
        billingTableModel.addRow(new String[]{"B2", "P2", "500", "Unpaid"});
        billingTableModel.addRow(new String[]{"B3", "P3", "1000", "Paid"});
        billingTableModel.addRow(new String[]{"B4", "P4", "750", "Unpaid"});
        billingTableModel.addRow(new String[]{"B5", "P5", "300", "Paid"});


        // Main menu panel with colorful design
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(245, 245, 250));

        // Title label
        JLabel titleLabel = new JLabel("🏥 MODI-MEDICARE: Comprehensive Healthcare 🏥", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 28));
        titleLabel.setForeground(new Color(60, 90, 170));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(8, 1, 10, 10));
        buttonPanel.setOpaque(false);

        JButton doctorButton = createStyledButton("Doctor DataSheet", new Color(120, 180, 200));
        JButton patientButton = createStyledButton("Patient DataSheet", new Color(200, 100, 120));
        JButton inventoryButton = createStyledButton("Inventory", new Color(150, 180, 100));
        JButton labButton = createStyledButton("Lab Tests", new Color(180, 120, 150));
        JButton labOrdersButton = createStyledButton("Lab Orders", new Color(180, 180, 220));
        JButton facilityButton = createStyledButton("Facility", new Color(100, 160, 180));
        JButton staffButton = createStyledButton("Staff", new Color(180, 150, 100));
        JButton appointmentsButton = createStyledButton("Appointments", new Color(160, 200, 180));
        JButton opdButton = createStyledButton("OPD", new Color(220, 200, 150));
        JButton ipdButton = createStyledButton("IPD", new Color(130, 140, 190));
        JButton billingButton = createStyledButton("Billings SpreadSheet", new Color(180, 160, 120));
        JButton exitButton = createStyledButton("Exit", Color.RED);

        // Add buttons to buttonPanel
        buttonPanel.add(doctorButton);
        buttonPanel.add(patientButton);
        buttonPanel.add(inventoryButton);
        buttonPanel.add(labButton);
	    buttonPanel.add(labOrdersButton);
        buttonPanel.add(facilityButton);
        buttonPanel.add(staffButton);
        buttonPanel.add(appointmentsButton);
        buttonPanel.add(opdButton);
        buttonPanel.add(ipdButton);
        buttonPanel.add(billingButton);
        buttonPanel.add(exitButton);

        // Add button panel to main panel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add main panel to frame
        add(mainPanel, BorderLayout.CENTER);

        // Button listeners
        doctorButton.addActionListener(e -> showSection("Doctor Section", doctorTableModel, new String[]{"ID", "Name", "Specialist", "Work Time", "Qualification", "Room"}, new Color(120, 180, 200)));
        patientButton.addActionListener(e -> showSection("Patient Section", patientTableModel, new String[]{"ID", "Name", "Disease", "Sex", "Admit Status", "Age"}, new Color(200, 100, 120)));
        inventoryButton.addActionListener(e -> showSection("inventory Section", inventoryTableModel, new String[]{"ID", "Name", "Type", "Quantity", "Price"}, new Color(150, 180, 100)));
        labButton.addActionListener(e -> showSection("Lab Section", labTableModel, new String[]{"ID", "Test Name", "Cost", "Available"}, new Color(180, 120, 150)));
	    labOrdersButton.addActionListener(e -> showSection("Lab Orders Section", labOrdersTableModel, new String[]{"Order ID", "Patient ID", "Test ID", "Order Date"}, new Color(180, 180, 220)));
        facilityButton.addActionListener(e -> showSection("Facility Section", facilityTableModel, new String[]{"ID", "Facility Name", "Details"}, new Color(100, 160, 180)));
        staffButton.addActionListener(e -> showSection("Staff Section", staffTableModel, new String[]{"ID", "Name", "Position", "Salary"}, new Color(180, 150, 100)));
        appointmentsButton.addActionListener(e -> showSection("Appointments Section", appointmentsTableModel, new String[]{"Patient ID", "Doctor ID", "Appointment Date(DD-MM-YYYY)", "Appointment Time"}, new Color(160, 200, 180)));
	    opdButton.addActionListener(e -> showSection("OPD Section",opdTableModel, new String[]{"Patient ID", "Doctor ID", "Visit Date", "Status"}, new Color(220, 200, 150)));
	    ipdButton.addActionListener(e -> showSection("IPD Section",ipdTableModel, new String[]{"Patient ID", "Doctor ID", "Admit Date", "Room", "Status"}, new Color(130, 140, 190)));
	    billingButton.addActionListener(e -> showSection("Billing Section", billingTableModel, new String[]{"Bill ID", "Patient ID", "Total Amount", "Payment Status"}, new Color(180, 160, 120)));
        exitButton.addActionListener(e -> System.exit(0));

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createStyledButton(String text, Color color) 
    {
        JButton button = new JButton(text);
        button.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        return button;
    }

    private void showSection(String title, DefaultTableModel model, String[] columns, Color color) 
    {
        JFrame sectionFrame = new JFrame(title);
        sectionFrame.setSize(800, 600);

        JPanel sectionPanel = new JPanel(new BorderLayout());
        sectionPanel.setBackground(color);

        JLabel sectionLabel = new JLabel(title, SwingConstants.CENTER);
        sectionLabel.setFont(new Font("TimesNewRoman", Font.BOLD, 18));
        sectionLabel.setForeground(new Color(60, 90, 170));
        sectionPanel.add(sectionLabel, BorderLayout.NORTH);

        JTable sectionTable = new JTable(model);
        sectionTable.setFont(new Font("TimesNewRoman", Font.PLAIN, 14));
        sectionTable.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(sectionTable);
        sectionPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(color);
        JTextField searchField = new JTextField(15);
        JButton searchButton = createStyledButton("Search", color.darker());

        controlPanel.add(new JLabel("Search by Name:"));
        controlPanel.add(searchField);
        controlPanel.add(searchButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(color);
        JButton addButton = createStyledButton("Add Entry", color.darker());
        JButton editButton = createStyledButton("Edit Entry", color.darker());
	    JButton deleteButton = createStyledButton("Delete Entry", color.darker());
        JButton returnButton = createStyledButton("Return to Main Menu", color.darker());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
	    buttonPanel.add(deleteButton);
        buttonPanel.add(returnButton);

        sectionPanel.add(controlPanel, BorderLayout.NORTH);
        sectionPanel.add(buttonPanel, BorderLayout.SOUTH);

        sectionFrame.add(sectionPanel);
        sectionFrame.setLocationRelativeTo(null);
        sectionFrame.setVisible(true);

        // Table row sorter for search and sorting
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        sectionTable.setRowSorter(sorter);

        searchButton.addActionListener(e -> 
        {
            String text = searchField.getText();
            if (text.trim().length() == 0) 
            {
                sorter.setRowFilter(null);
            } 
            else 
            {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1));
            }
        });


        addButton.addActionListener(e -> addEditOrDeleteEntry(title, model, columns, null));
        editButton.addActionListener(e -> 
        {
            int selectedRow = sectionTable.getSelectedRow();
            if (selectedRow >= 0) 
            {
                addEditOrDeleteEntry(title, model, columns, selectedRow);
            } 
            else 
            {
                JOptionPane.showMessageDialog(sectionFrame, "Please select a row to edit.");
            }
        });
	    deleteButton.addActionListener(e -> 
        {
            int selectedRow = sectionTable.getSelectedRow();
            if (selectedRow != -1) 
            {
                model.removeRow(selectedRow);
            } 
            else 
            {
                JOptionPane.showMessageDialog(sectionFrame, "Please select a row to delete.");
            }
        });
        returnButton.addActionListener(e -> sectionFrame.dispose());
    }

    private void addEditOrDeleteEntry(String title, DefaultTableModel model, String[] columns, Integer rowIndex) 
    {
        JPanel inputPanel = new JPanel(new GridLayout(columns.length, 2, 5, 5));
        JTextField[] fields = new JTextField[columns.length];

        String[] originalValues = new String[columns.length];
        if (rowIndex != null) 
        {
            for (int i = 0; i < columns.length; i++) 
            {
                originalValues[i] = (String) model.getValueAt(rowIndex, i);
                fields[i] = new JTextField(originalValues[i]);
            }
        } 
        else 
        {
            for (int i = 0; i < columns.length; i++) 
            {
                fields[i] = new JTextField();
            }
        }

        // Add labels and fields to the input panel
        for (int i = 0; i < columns.length; i++) 
        {
            inputPanel.add(new JLabel(columns[i]));
            inputPanel.add(fields[i]);
        }

        // Display the input dialog
        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Add/Edit Entry", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) 
        {
            boolean emptyField = false;
            for (JTextField field : fields) 
            {
                if (field.getText().trim().isEmpty()) 
                {
                    emptyField = true;
                    break;
                }
            }

            if (emptyField) 
            {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else 
            {
                String[] newRow = new String[fields.length];
                boolean isModified = false;

                // Check if any field is modified
                for (int i = 0; i < fields.length; i++) 
                {
                    newRow[i] = fields[i].getText();
                    if (rowIndex == null || !newRow[i].equals(originalValues[i])) 
                    {
                        isModified = true;
                    }
                }

                // If it's a new entry or any field was modified, update the table
                if (isModified) 
                {
                    if (rowIndex != null) 
                    {
                        // Update existing row
                        for (int i = 0; i < fields.length; i++) 
                        {
                            model.setValueAt(newRow[i], rowIndex, i);
                        }
                    } 
                    else 
                    {
                        // Add new row
                        model.addRow(newRow);
                    }
                }
       	    }
        }
    }
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(HOSPITALMGTGUI::new);
    }
}