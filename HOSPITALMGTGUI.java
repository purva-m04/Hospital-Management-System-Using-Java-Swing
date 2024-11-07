import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class IsCorrect extends Exception {
    IsCorrect(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}


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
        doctorTableModel.addRow(new String[]{"D1", "DR. PURVA", "CARDIOLOGIST", "9-5", "MBBS,MD", "101"});
        doctorTableModel.addRow(new String[]{"D2", "DR. BROWN", "NEUROLOGIST", "9-3", "MBBS,PHD", "102"});
        doctorTableModel.addRow(new String[]{"D3", "DR. LEE", "PEDIATRICIAN", "10-4", "MBBS,MD", "103"});
        doctorTableModel.addRow(new String[]{"D4", "DR. PATEL", "DERMATOLOGIST", "9-5", "MBBS", "104"});
        doctorTableModel.addRow(new String[]{"D5", "DR. JONES", "SURGEON", "8-6", "MBBS,MS", "105"});

        patientTableModel = new DefaultTableModel(new String[]{"ID", "Name", "Disease", "Sex", "Admit Status", "Age"}, 0);
        patientTableModel.addRow(new String[]{"P1", "JOHN DOE", "FLU", "M", "ADMITTED", "34"});
        patientTableModel.addRow(new String[]{"P2", "JANE WATSON", "FEVER", "F", "DISCHARGED", "29"});
        patientTableModel.addRow(new String[]{"P3", "MICHAEL MYERS", "HEADACHE", "M", "ADMITTED", "45"});
        patientTableModel.addRow(new String[]{"P4", "EMILY STONE", "COLD", "F", "DISCHARGED", "22"});
        patientTableModel.addRow(new String[]{"P5", "CHRIS GREEN", "COUGH", "M", "ADMITTED", "60"});

        inventoryTableModel = new DefaultTableModel(new String[]{"ID", "Name", "Type", "Quantity", "Price"}, 0);
        inventoryTableModel.addRow(new String[]{"M1", "PARACETAMOL", "TABLET", "100", "5"});
        inventoryTableModel.addRow(new String[]{"M2", "ASPIRIN", "TABLET", "50", "3"});
        inventoryTableModel.addRow(new String[]{"M3", "AMOXICILLIN", "CAPSULE", "80", "10"});
        inventoryTableModel.addRow(new String[]{"M4", "IBUPROFEN", "TABLET", "150", "6"});
        inventoryTableModel.addRow(new String[]{"M5", "LISINOPRIL", "TABLET", "200", "8"});

        labTableModel = new DefaultTableModel(new String[]{"ID", "Test Name", "Cost", "Available"}, 0);
        labTableModel.addRow(new String[]{"L1", "BLOOD TEST", "200", "YES"});
        labTableModel.addRow(new String[]{"L2", "X-RAY", "500", "NO"});
        labTableModel.addRow(new String[]{"L3", "MRI", "1500", "YES"});
        labTableModel.addRow(new String[]{"L4", "CT SCAN", "1200", "YES"});
        labTableModel.addRow(new String[]{"L5", "ULTRASOUND", "800", "YES"});

        labOrdersTableModel = new DefaultTableModel(new String[]{"Order ID", "Patient ID", "Test ID", "Order Date"}, 0);
        labOrdersTableModel.addRow(new String[]{"O1", "P1", "L1", "05-11-2024"});
        labOrdersTableModel.addRow(new String[]{"O2", "P2", "L2", "06-11-2024"});
        labOrdersTableModel.addRow(new String[]{"O3", "P3", "L3", "07-11-2024"});
        labOrdersTableModel.addRow(new String[]{"O4", "P4", "L4", "08-11-2024"});
        labOrdersTableModel.addRow(new String[]{"O5", "P5", "L5", "09-11-2024"});

        facilityTableModel = new DefaultTableModel(new String[]{"ID", "Facility Name", "Details"}, 0);
        facilityTableModel.addRow(new String[]{"F1", "ICU", "INTENSIVE CARE UNIT"});
        facilityTableModel.addRow(new String[]{"F2", "ER", "EMERGENCY ROOM"});
        facilityTableModel.addRow(new String[]{"F3", "RADIOLOGY", "RADIOLOGY SERVICES"});
        facilityTableModel.addRow(new String[]{"F4", "PHARMACY", "MEDICINE DISPENSING"});
        facilityTableModel.addRow(new String[]{"F5", "SURGERY", "OPERATION THEATRE"});

        staffTableModel = new DefaultTableModel(new String[]{"ID", "Name", "Position", "Salary"}, 0);
        staffTableModel.addRow(new String[]{"S1", "AISHWARYA", "NURSE", "5000"});
        staffTableModel.addRow(new String[]{"S2", "HITEN", "RECEPTIONIST", "3000"});
	    staffTableModel.addRow(new String[]{"S3", "JOHN", "ADMINISTRATOR", "4000"});
        staffTableModel.addRow(new String[]{"S4", "ARUN", "PHARMACIST", "5200"});
        staffTableModel.addRow(new String[]{"S5", "PRASAD", "LAB TECHNICIAN", "2500"});

        appointmentsTableModel = new DefaultTableModel(new String[]{"Patient ID", "Doctor ID", "Appointment Date", "Appointment Time"}, 0);
        appointmentsTableModel.addRow(new String[]{"P1", "D1", "05-11-2024", "02:30 PM"});
        appointmentsTableModel.addRow(new String[]{"P2", "D2", "06-11-2024", "10:00 AM"});
        appointmentsTableModel.addRow(new String[]{"P3", "D3", "07-11-2024", "11:00 AM"});
        appointmentsTableModel.addRow(new String[]{"P4", "D4", "08-11-2024", "01:00 PM"});
        appointmentsTableModel.addRow(new String[]{"P5", "D5", "09-11-2024", "03:00 PM"});

        opdTableModel = new DefaultTableModel(new String[]{"Patient ID", "Doctor ID", "Visit Date", "Status"}, 0);
        opdTableModel.addRow(new String[]{"P1", "D1", "01-11-2024", "COMPLETED"});
        opdTableModel.addRow(new String[]{"P2", "D2", "02-11-2024", "COMPLETED"});
        opdTableModel.addRow(new String[]{"P3", "D3", "03-11-2024", "IN PROGRESS"});
        opdTableModel.addRow(new String[]{"P4", "D4", "04-11-2024", "PENDING"});
        opdTableModel.addRow(new String[]{"P5", "D5", "05-11-2024", "COMPLETED"});

        ipdTableModel = new DefaultTableModel(new String[]{"Patient ID", "Doctor ID", "Admit Date", "Room", "Status"}, 0);
        ipdTableModel.addRow(new String[]{"P1", "D1", "01-11-2024", "101", "ADMITTED"});
        ipdTableModel.addRow(new String[]{"P2", "D2", "02-11-2024", "102", "DISCHARGED"});
        ipdTableModel.addRow(new String[]{"P3", "D3", "03-11-2024", "103", "ADMITTED"});
        ipdTableModel.addRow(new String[]{"P4", "D4", "04-11-2024", "104", "PENDING"});
        ipdTableModel.addRow(new String[]{"P5", "D5", "05-11-2024", "105", "ADMITTED"});

        billingTableModel = new DefaultTableModel(new String[]{"Bill ID", "Patient ID", "Total Amount", "Payment Status"}, 0);
        billingTableModel.addRow(new String[]{"B1", "P1", "250", "PAID"});
        billingTableModel.addRow(new String[]{"B2", "P2", "500", "UNPAID"});
        billingTableModel.addRow(new String[]{"B3", "P3", "1000", "PAID"});
        billingTableModel.addRow(new String[]{"B4", "P4", "750", "UNPAID"});
        billingTableModel.addRow(new String[]{"B5", "P5", "300", "PAID"});


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
	private boolean isText(String input) {
  
    if (input != null && input.matches("[a-zA-Z]+")) {
        return true;  
    } else {
        return false; 
    }
}


private void addEditOrDeleteEntry(String title, DefaultTableModel model, String[] columns, Integer rowIndex) 
{
    boolean inputValid;
    do 
    {
        JPanel inputPanel = new JPanel(new GridLayout(columns.length, 2, 5, 5));
        JTextField[] fields = new JTextField[columns.length];
        inputValid = true;

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
            try 
            {
                for (int i = 0; i < columns.length; i++) 
                {
                    String value = fields[i].getText().trim();
                    if (value.isEmpty()) 
                    {
                        inputValid = false;
                        JOptionPane.showMessageDialog(null, "Field " + columns[i] + " cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    if (i == 0) 
                    {
                        value = value.toUpperCase();
                    }

                    if (i == 1 && !isText(value)) 
                    {
                        throw new IsCorrect("Name has to contain only letters.");
                    } 
                    else 
                    {
                        value = value.toUpperCase();
                    }


                    if (rowIndex != null && !value.equals(originalValues[i])) 
                    {

                        inputValid = true;
                    }

                    fields[i].setText(value);
                }

            } 
            catch (IsCorrect e) 
            {
                JOptionPane.showMessageDialog(null, e.toString());
                inputValid = false;
            }
            
            if (inputValid) 
            {

                if (rowIndex != null) 
                {

                    for (int i = 0; i < columns.length; i++) 
                    {
                        model.setValueAt(fields[i].getText(), rowIndex, i);
                    }
                } 
                else 
                {

                    model.addRow(Arrays.stream(fields).map(JTextField::getText).toArray());
                }
            }
        }
        else 
        {

            break;
        }

    } while (!inputValid);
}


    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(HOSPITALMGTGUI::new);
    }
}
