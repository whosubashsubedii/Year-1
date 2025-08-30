import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

// // Abstract base class for visitors - kinda like a template for all visitor types!
// abstract class ArtGalleryVisitor implements Serializable {
    // protected int visitorId;        // Unique ID for each visitor
    // protected String name;         // Visitor's name
    // protected String gender;       // Gender info
    // protected String contact;      // Contact details
    // protected String regDate;      // When they registered
    // protected double ticketPrice;  // Cost of their ticket
    // protected String ticketType;   // Type of ticket (Standard or Elite)

    // // Constructor to set up a new visitor
    // public ArtGalleryVisitor(int id, String name, String gender, String contact, String regDate, double ticketPrice, String ticketType) {
        // this.visitorId = id;
        // this.name = name;
        // this.gender = gender;
        // this.contact = contact;
        // this.regDate = regDate;
        // this.ticketPrice = ticketPrice;
        // this.ticketType = ticketType;
    // }

    // // Basic getters - let's grab the info when we need it!
    // public int getVisitorId() { return visitorId; }
    // public String getName() { return name; }
    // public String getGender() { return gender; }
    // public String getContact() { return contact; }
    // public String getRegDate() { return regDate; }
    // public double getTicketPrice() { return ticketPrice; }
    // public String getTicketType() { return ticketType; }

    // // Abstract method - subclasses will fill this in
    // public abstract String getVisitorDetails();

    // // Placeholder methods - to be implemented based on requirements
    // public void logVisit() {
        // // Placeholder: Implement visit logging logic (e.g., increment visit count)
        // System.out.println("Visit logged for Visitor ID: " + visitorId);
    // }

    // public String buyProduct(String artworkName, double artworkPrice) {
        // // Placeholder: Implement product purchase logic
        // return "Product bought: " + artworkName + " for $" + artworkPrice + " by Visitor ID " + visitorId;
    // }

    // public String cancelProduct(String artworkName, String cancellationReason) {
        // // Placeholder: Implement product cancellation logic
        // return "Product canceled: " + artworkName + " by Visitor ID " + visitorId + " (Reason: " + cancellationReason + ")";
    // }

    // public double calculateDiscount() {
        // // Placeholder: Implement discount calculation (e.g., 10% discount)
        // return ticketPrice * 0.10;
    // }

    // public double calculateRewardPoints() {
        // // Placeholder: Implement reward points calculation (e.g., 2 points per dollar)
        // return ticketPrice * 2;
    // }

    // public void generateBill() {
        // // Placeholder: Implement bill generation logic
        // System.out.println("Bill for " + name + " (ID: " + visitorId + "): $" + ticketPrice);
    // }

    // public void display() {
        // // Placeholder: Implement display logic
        // System.out.println(getVisitorDetails());
    // }
// }

// // StandardVisitor class - for the regular folks!
// class StandardVisitor extends ArtGalleryVisitor {
    // // Constructor for a standard visitor
    // public StandardVisitor(int id, String name, String gender, String contact, String regDate, double ticketPrice) {
        // super(id, name, gender, contact, regDate, ticketPrice, "Standard Pass");
    // }

    // // Override to give a nice summary of the visitor
    // @Override
    // public String getVisitorDetails() {
        // return String.format("Standard Visitor: ID=%d, Name=%s, Gender=%s, Contact=%s, Date=%s, Price=$%.2f",
                // visitorId, name, gender, contact, regDate, ticketPrice);
    // }
// }

// // EliteVisitor class - for the VIPs!
// class EliteVisitor extends ArtGalleryVisitor {
    // private String advisor;  // Who’s helping this elite visitor?

    // // Constructor with an unassigned advisor to start
    // public EliteVisitor(int id, String name, String gender, String contact, String regDate, double ticketPrice) {
        // super(id, name, gender, contact, regDate, ticketPrice, "Elite Pass");
        // this.advisor = "Not Assigned";
    // }

    // // Set or change the advisor
    // public void setAdvisor(String advisor) { this.advisor = advisor; }
    // public String getAdvisor() { return advisor; }

    // // Override to include the advisor in the details
    // @Override
    // public String getVisitorDetails() {
        // return String.format("Elite Visitor: ID=%d, Name=%s, Gender=%s, Contact=%s, Date=%s, Price=$%.2f, Advisor=%s",
                // visitorId, name, gender, contact, regDate, ticketPrice, advisor);
    // }
// }

// Main GUI class - where the magic happens!
public class ArtGalleryGUI extends JFrame {
    private JTextField txtVisitorId, txtCustomerName, txtContactNumber, txtTicketPrice, txtArtwork, txtArtworkPrice, txtCancelReason;
    private JRadioButton rbtnMale, rbtnFemale, rbtnOther;
    private ButtonGroup genderGroup;
    private JComboBox<String> cbDay, cbMonth, cbYear, cbTicketType;
    private JButton btnVisitorInfo, btnActions, btnVisitorLog, btnClear, btnAddVisitor;
    private JButton btnLogVisit, btnBuyProduct, btnCancelProduct, btnAssignAdvisor;
    private JButton btnCheckUpgrade, btnDiscount, btnRewardPoints, btnGenerateBill;
    private JButton btnSaveToFile, btnReadFromFile, btnDisplayVisitorDetails;
    private JTextArea txtOutput;
    private ArrayList<ArtGalleryVisitor> visitorList;

    public ArtGalleryGUI() {
        // Set up the frame
        setTitle("Art Gallery System");  // Set the window title
        setSize(600, 900);             // Size of the window
        setLocationRelativeTo(null);   // Center it on the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);  // Close app when window is closed
        setLayout(null);              // Manual layout control

        visitorList = new ArrayList<>();  // List to store our visitors

        // Title Label - make it stand out!
        JLabel lblTitle = new JLabel("Art Gallery System");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setBounds(0, 10, 600, 30);
        lblTitle.setBackground(new Color(230, 243, 230)); // Light Green
        lblTitle.setOpaque(true);
        add(lblTitle);

        // Top Buttons - navigation options
        btnVisitorInfo = new JButton("Visitor Info");
        btnVisitorInfo.setBounds(50, 50, 120, 30);
        btnVisitorInfo.setBackground(new Color(240, 240, 240)); // Light Gray
        btnActions = new JButton("Actions");
        btnActions.setBounds(230, 50, 120, 30);
        btnActions.setBackground(new Color(240, 240, 240));
        btnVisitorLog = new JButton("Visitor Log");
        btnVisitorLog.setBounds(430, 50, 120, 30);
        btnVisitorLog.setBackground(new Color(240, 240, 240));
        add(btnVisitorInfo); add(btnActions); add(btnVisitorLog);

        // Visitor Info Panel - where we input visitor details
        JPanel visitorInfoPanel = new JPanel();
        visitorInfoPanel.setBorder(BorderFactory.createTitledBorder("Visitor Info"));
        visitorInfoPanel.setBounds(50, 100, 500, 350);
        visitorInfoPanel.setLayout(null);
        visitorInfoPanel.setBackground(new Color(245, 245, 220)); // Beige
        visitorInfoPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        txtVisitorId = new JTextField();
        txtVisitorId.setBounds(150, 20, 150, 25);
        JLabel lblVisitorId = new JLabel("Visitor ID:");
        lblVisitorId.setFont(new Font("Arial", Font.BOLD, 12));
        lblVisitorId.setBounds(50, 20, 100, 25);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(150, 60, 150, 25);
        JLabel lblCustomerName = new JLabel("Customer Name:");
        lblCustomerName.setFont(new Font("Arial", Font.BOLD, 12));
        lblCustomerName.setBounds(50, 60, 100, 25);

        rbtnMale = new JRadioButton("Male");
        rbtnMale.setBounds(150, 90, 60, 25);
        rbtnFemale = new JRadioButton("Female");
        rbtnFemale.setBounds(220, 90, 70, 25);
        rbtnOther = new JRadioButton("Other (Not Prefer to say)");
        rbtnOther.setBounds(300, 90, 150, 25);
        genderGroup = new ButtonGroup();
        genderGroup.add(rbtnMale); genderGroup.add(rbtnFemale); genderGroup.add(rbtnOther);
        JLabel lblGender = new JLabel("Gender:");
        lblGender.setFont(new Font("Arial", Font.BOLD, 12));
        lblGender.setBounds(50, 90, 100, 25);

        txtContactNumber = new JTextField();
        txtContactNumber.setBounds(150, 120, 150, 25);
        JLabel lblContactNumber = new JLabel("Customer Contact Number:");
        lblContactNumber.setFont(new Font("Arial", Font.BOLD, 12));
        lblContactNumber.setBounds(50, 120, 120, 25);

        cbDay = new JComboBox<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
        cbDay.setBounds(150, 150, 50, 25);
        cbMonth = new JComboBox<>(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        cbMonth.setBounds(210, 150, 70, 25);
        cbYear = new JComboBox<>(new String[]{"2024", "2025"});
        cbYear.setBounds(290, 150, 70, 25);
        JLabel lblRegDate = new JLabel("Reg Date:");
        lblRegDate.setFont(new Font("Arial", Font.BOLD, 12));
        lblRegDate.setBounds(50, 150, 100, 25);
        JLabel lblCalendar = new JLabel("");
        lblCalendar.setBounds(360, 150, 20, 25);

        cbTicketType = new JComboBox<>(new String[]{"Standard Pass", "Elite Pass"});
        cbTicketType.setBounds(150, 195, 150, 25);
        txtTicketPrice = new JTextField();
        txtTicketPrice.setBounds(350, 195, 100, 25);
        txtTicketPrice.setEditable(false);
        // Update price based on ticket type selection
        cbTicketType.addActionListener(e -> {
            String selected = (String) cbTicketType.getSelectedItem();
            txtTicketPrice.setText(selected.equals("Standard Pass") ? "100" : "200");
        });
        JLabel lblTicketType = new JLabel("Ticket Type:");
        lblTicketType.setFont(new Font("Arial", Font.BOLD, 12));
        lblTicketType.setBounds(50, 195, 100, 25);
        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setFont(new Font("Arial", Font.BOLD, 12));
        lblPrice.setBounds(310, 180, 40, 25);

        txtArtwork = new JTextField();
        txtArtwork.setBounds(150, 230, 150, 25);
        JLabel lblArtwork = new JLabel("Artwork:");
        lblArtwork.setFont(new Font("Arial", Font.BOLD, 12));
        lblArtwork.setBounds(50, 230, 100, 25);
        txtArtworkPrice = new JTextField();
        txtArtworkPrice.setBounds(350, 230, 100, 25);
        JLabel lblArtworkPrice = new JLabel("Price:");
        lblArtworkPrice.setFont(new Font("Arial", Font.BOLD, 12));
        lblArtworkPrice.setBounds(310, 230, 40, 25);

        txtCancelReason = new JTextField();
        txtCancelReason.setBounds(150, 270, 150, 25);
        JLabel lblCancelReason = new JLabel("Cancel Reason:");
        lblCancelReason.setFont(new Font("Arial", Font.BOLD, 12));
        lblCancelReason.setBounds(50, 270, 100, 25);

        btnClear = new JButton("Clear");
        btnClear.setBounds(150, 305, 100, 30);
        btnClear.setBackground(new Color(240, 240, 240));
        btnAddVisitor = new JButton("Add Visitor");
        btnAddVisitor.setBounds(350, 305, 100, 30);
        btnAddVisitor.setBackground(new Color(173, 216, 230)); // Blue

        visitorInfoPanel.add(lblVisitorId); visitorInfoPanel.add(txtVisitorId);
        visitorInfoPanel.add(lblCustomerName); visitorInfoPanel.add(txtCustomerName);
        visitorInfoPanel.add(lblGender); visitorInfoPanel.add(rbtnMale);
        visitorInfoPanel.add(rbtnFemale); visitorInfoPanel.add(rbtnOther);
        visitorInfoPanel.add(lblContactNumber); visitorInfoPanel.add(txtContactNumber);
        visitorInfoPanel.add(lblRegDate); visitorInfoPanel.add(cbDay);
        visitorInfoPanel.add(cbMonth); visitorInfoPanel.add(cbYear); visitorInfoPanel.add(lblCalendar);
        visitorInfoPanel.add(lblTicketType); visitorInfoPanel.add(cbTicketType);
        visitorInfoPanel.add(lblPrice); visitorInfoPanel.add(txtTicketPrice);
        visitorInfoPanel.add(lblArtwork); visitorInfoPanel.add(txtArtwork);
        visitorInfoPanel.add(lblArtworkPrice); visitorInfoPanel.add(txtArtworkPrice);
        visitorInfoPanel.add(lblCancelReason); visitorInfoPanel.add(txtCancelReason);
        visitorInfoPanel.add(btnClear); visitorInfoPanel.add(btnAddVisitor);
        add(visitorInfoPanel);

        // Visitor Actions Panel - all the fun stuff happens here
        JPanel visitorActionsPanel = new JPanel();
        visitorActionsPanel.setBorder(BorderFactory.createTitledBorder("Visitor Actions"));
        visitorActionsPanel.setBounds(50, 470, 500, 200);
        visitorActionsPanel.setLayout(null);
        visitorActionsPanel.setBackground(new Color(230, 243, 230)); // Light Green
        visitorActionsPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        btnLogVisit = new JButton("Log Visit");
        btnLogVisit.setBounds(15, 20, 125, 30);
        btnLogVisit.setBackground(new Color(240, 240, 240));
        
        btnBuyProduct = new JButton("Buy Product");
        btnBuyProduct.setBounds(185, 20, 125, 30);
        btnBuyProduct.setBackground(new Color(240, 240, 240));
        
        btnCancelProduct = new JButton("Cancel Product");
        btnCancelProduct.setBounds(365, 20, 125, 30);
        btnCancelProduct.setBackground(new Color(240, 240, 240));
        
        btnAssignAdvisor = new JButton("Assign Advisor");
        btnAssignAdvisor.setBounds(15, 60, 125, 30);
        btnAssignAdvisor.setBackground(new Color(240, 240, 240));
        
        btnCheckUpgrade = new JButton("Check Upgrade");
        btnCheckUpgrade.setBounds(185, 60, 125, 30);
        btnCheckUpgrade.setBackground(new Color(240, 240, 240));
        
        btnDiscount = new JButton("Discount");
        btnDiscount.setBounds(365, 60, 125, 30);
        btnDiscount.setBackground(new Color(240, 240, 240));
        
        btnRewardPoints = new JButton("Reward Points");
        btnRewardPoints.setBounds(15, 100, 125, 30);
        btnRewardPoints.setBackground(new Color(240, 240, 240));
        
        btnGenerateBill = new JButton("Generate Bill");
        btnGenerateBill.setBounds(185, 100, 125, 30);
        btnGenerateBill.setBackground(new Color(240, 240, 240));
        
        btnSaveToFile = new JButton("Save to File");
        btnSaveToFile.setBounds(365, 100, 125, 30);
        btnSaveToFile.setBackground(new Color(240, 240, 240));
        
        btnReadFromFile = new JButton("Read from File");
        btnReadFromFile.setBounds(185, 140, 125, 30);
        btnReadFromFile.setBackground(new Color(240, 240, 240));

        btnDisplayVisitorDetails = new JButton("Display Visitor Details");
        btnDisplayVisitorDetails.setBounds(15, 140, 150, 30);
        btnDisplayVisitorDetails.setBackground(new Color(240, 240, 240));

        visitorActionsPanel.add(btnLogVisit); visitorActionsPanel.add(btnBuyProduct); visitorActionsPanel.add(btnCancelProduct);
        visitorActionsPanel.add(btnAssignAdvisor); visitorActionsPanel.add(btnCheckUpgrade); visitorActionsPanel.add(btnDiscount);
        visitorActionsPanel.add(btnRewardPoints); visitorActionsPanel.add(btnGenerateBill); visitorActionsPanel.add(btnSaveToFile);
        visitorActionsPanel.add(btnReadFromFile); visitorActionsPanel.add(btnDisplayVisitorDetails);
        add(visitorActionsPanel);

        // Output Panel - where we show the results
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBounds(50, 690, 500, 150);
        scrollPane.setBackground(new Color(245, 245, 220)); // Beige
        JLabel lblOutput = new JLabel("Output Display");
        lblOutput.setBounds(50, 670, 150, 20);
        add(lblOutput); add(scrollPane);

        // Action Listeners - what happens when buttons are clicked
        btnAddVisitor.addActionListener(e -> addVisitor());
        btnClear.addActionListener(e -> clearFields());
        btnLogVisit.addActionListener(e -> logVisit());
        btnBuyProduct.addActionListener(e -> buyProduct());
        btnCancelProduct.addActionListener(e -> cancelProduct());
        btnAssignAdvisor.addActionListener(e -> assignAdvisor());
        btnCheckUpgrade.addActionListener(e -> checkUpgrade());
        btnDiscount.addActionListener(e -> calculateDiscount());
        btnRewardPoints.addActionListener(e -> calculateRewardPoints());
        btnGenerateBill.addActionListener(e -> generateBill());
        btnSaveToFile.addActionListener(e -> saveToFile());
        btnReadFromFile.addActionListener(e -> readFromFile());
        btnDisplayVisitorDetails.addActionListener(e -> displayVisitorDetails());

        setVisible(true);  // Show the window!
    }

    private void addVisitor() {
        try {
            int visitorId = Integer.parseInt(txtVisitorId.getText().trim());
            for (ArtGalleryVisitor visitor : visitorList) {
                if (visitor.getVisitorId() == visitorId) {
                    JOptionPane.showMessageDialog(this, "Error: Visitor ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            String name = txtCustomerName.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: Customer Name is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String gender = rbtnMale.isSelected() ? "Male" : rbtnFemale.isSelected() ? "Female" : rbtnOther.isSelected() ? "Other" : "";
            if (gender.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: Please select a gender!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String contact = txtContactNumber.getText().trim();
            if (contact.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: Contact Number is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String regDate = cbDay.getSelectedItem() + "-" + cbMonth.getSelectedItem() + "-" + cbYear.getSelectedItem();
            double ticketPrice = Double.parseDouble(txtTicketPrice.getText().trim());
            String ticketType = (String) cbTicketType.getSelectedItem();

            ArtGalleryVisitor visitor;
            if (ticketType.equals("Standard Pass")) {
                visitor = new StandardVisitor(visitorId, name, gender, contact, regDate, ticketPrice);
            } else {
                visitor = new EliteVisitor(visitorId, name, gender, contact, regDate, ticketPrice);
            }

            visitorList.add(visitor);
            txtOutput.append("Visitor added successfully: " + visitor.getVisitorDetails() + "\n");
            JOptionPane.showMessageDialog(this, "Visitor added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Invalid number format for Visitor ID or Ticket Price!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtVisitorId.setText("");
        txtCustomerName.setText("");
        txtContactNumber.setText("");
        txtTicketPrice.setText("");
        txtArtwork.setText("");
        txtArtworkPrice.setText("");
        txtCancelReason.setText("");
        genderGroup.clearSelection();
        cbDay.setSelectedIndex(0);
        cbMonth.setSelectedIndex(0);
        cbYear.setSelectedIndex(0);
        cbTicketType.setSelectedIndex(0);
        txtOutput.append("Fields cleared!\n");
        JOptionPane.showMessageDialog(this, "Fields cleared successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private ArtGalleryVisitor findVisitor(int visitorId) {
        for (ArtGalleryVisitor visitor : visitorList) {
            if (visitor.getVisitorId() == visitorId) {
                return visitor;
            }
        }
        return null;
    }

    private void logVisit() {
        try {
            int visitorId = Integer.parseInt(txtVisitorId.getText().trim());
            ArtGalleryVisitor visitor = findVisitor(visitorId);
            if (visitor == null) {
                JOptionPane.showMessageDialog(this, "Error: Visitor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            visitor.logVisit();
            txtOutput.append("Visit logged for Visitor ID: " + visitorId + "\n");
            JOptionPane.showMessageDialog(this, "Visit logged successfully for Visitor ID: " + visitorId, "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Invalid Visitor ID format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buyProduct() {
        try {
            int visitorId = Integer.parseInt(txtVisitorId.getText().trim());
            ArtGalleryVisitor visitor = findVisitor(visitorId);
            if (visitor == null) {
                JOptionPane.showMessageDialog(this, "Error: Visitor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String artwork = txtArtwork.getText().trim();
            if (artwork.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: Artwork Name is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double artworkPrice = Double.parseDouble(txtArtworkPrice.getText().trim());
            String result = visitor.buyProduct(artwork, artworkPrice);
            txtOutput.append(result + "\n");
            JOptionPane.showMessageDialog(this, "Product bought successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Invalid number format for Visitor ID or Artwork Price!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelProduct() {
        try {
            int visitorId = Integer.parseInt(txtVisitorId.getText().trim());
            ArtGalleryVisitor visitor = findVisitor(visitorId);
            if (visitor == null) {
                JOptionPane.showMessageDialog(this, "Error: Visitor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String artwork = txtArtwork.getText().trim();
            if (artwork.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: Artwork Name is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String reason = txtCancelReason.getText().trim();
            if (reason.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: Cancellation Reason is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String result = visitor.cancelProduct(artwork, reason);
            txtOutput.append(result + "\n");
            JOptionPane.showMessageDialog(this, "Product canceled successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Invalid Visitor ID format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void assignAdvisor() {
        try {
            int visitorId = Integer.parseInt(txtVisitorId.getText().trim());
            ArtGalleryVisitor visitor = findVisitor(visitorId);
            if (visitor == null) {
                JOptionPane.showMessageDialog(this, "Error: Visitor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (visitor instanceof EliteVisitor) {
                EliteVisitor eliteVisitor = (EliteVisitor) visitor;
                String advisorName = JOptionPane.showInputDialog(this, "Enter Advisor Name:");
                if (advisorName != null && !advisorName.trim().isEmpty()) {
                    eliteVisitor.setAdvisor(advisorName);
                    txtOutput.append("Advisor " + advisorName + " assigned to Visitor ID " + visitorId + "\n");
                    JOptionPane.showMessageDialog(this, "Advisor assigned successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    txtOutput.append("Advisor assignment canceled for Visitor ID " + visitorId + "\n");
                    JOptionPane.showMessageDialog(this, "Advisor name is required!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                txtOutput.append("Only Elite Visitors can have an Advisor (Visitor ID: " + visitorId + ")\n");
                JOptionPane.showMessageDialog(this, "Only Elite Visitors can have an Advisor!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Invalid Visitor ID format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void checkUpgrade() {
        try {
            int visitorId = Integer.parseInt(txtVisitorId.getText().trim());
            ArtGalleryVisitor visitor = findVisitor(visitorId);
            if (visitor == null) {
                JOptionPane.showMessageDialog(this, "Error: Visitor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Note: Placeholder since checkUpgrade() is not implemented
            if (visitor instanceof StandardVisitor) {
                txtOutput.append("Upgrade check for Visitor ID " + visitorId + ": Not implemented (Visit count not tracked)\n");
                JOptionPane.showMessageDialog(this, "Upgrade check performed. No upgrade logic implemented.", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                txtOutput.append("Only Standard Visitors can check for upgrade (Visitor ID: " + visitorId + ")\n");
                JOptionPane.showMessageDialog(this, "Only Standard Visitors can check for upgrade!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Invalid Visitor ID format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateDiscount() {
        try {
            int visitorId = Integer.parseInt(txtVisitorId.getText().trim());
            ArtGalleryVisitor visitor = findVisitor(visitorId);
            if (visitor == null) {
                JOptionPane.showMessageDialog(this, "Error: Visitor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double discount = visitor.calculateDiscount();
            txtOutput.append("Discount applied for Visitor ID " + visitorId + ": $" + discount + "\n");
            JOptionPane.showMessageDialog(this, "Discount applied: $" + discount, "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Invalid Visitor ID format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateRewardPoints() {
        try {
            int visitorId = Integer.parseInt(txtVisitorId.getText().trim());
            ArtGalleryVisitor visitor = findVisitor(visitorId);
            if (visitor == null) {
                JOptionPane.showMessageDialog(this, "Error: Visitor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double points = visitor.calculateRewardPoints();
            txtOutput.append("Reward Points for Visitor ID " + visitorId + ": " + points + "\n");
            JOptionPane.showMessageDialog(this, "Reward Points: " + points, "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Invalid Visitor ID format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generateBill() {
        try {
            int visitorId = Integer.parseInt(txtVisitorId.getText().trim());
            ArtGalleryVisitor visitor = findVisitor(visitorId);
            if (visitor == null) {
                JOptionPane.showMessageDialog(this, "Error: Visitor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            visitor.generateBill();
            txtOutput.append("Bill generated for Visitor ID " + visitorId + ". Check console for details.\n");
            JOptionPane.showMessageDialog(this, "Bill generated successfully. Check console for details.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Invalid Visitor ID format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayVisitorDetails() {
        try {
            int visitorId = Integer.parseInt(txtVisitorId.getText().trim());
            ArtGalleryVisitor visitor = findVisitor(visitorId);
            if (visitor == null) {
                JOptionPane.showMessageDialog(this, "Error: Visitor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            visitor.display();
            txtOutput.append("Visitor details displayed for Visitor ID " + visitorId + ": " + visitor.getVisitorDetails() + "\n");
            JOptionPane.showMessageDialog(this, "Visitor details displayed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Invalid Visitor ID format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("visitors.dat"))) {
            oos.writeObject(visitorList);
            txtOutput.append("Data saved to file successfully!\n");
            JOptionPane.showMessageDialog(this, "Data saved to file successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            txtOutput.append("Error saving to file: " + ex.getMessage() + "\n");
            JOptionPane.showMessageDialog(this, "Error saving to file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    private void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("visitors.dat"))) {
            visitorList = (ArrayList<ArtGalleryVisitor>) ois.readObject();
            txtOutput.append("Data read from file successfully!\n");
            for (ArtGalleryVisitor visitor : visitorList) {
                txtOutput.append(visitor.getVisitorDetails() + "\n");
            }
            JOptionPane.showMessageDialog(this, "Data read from file successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | ClassNotFoundException ex) {
            txtOutput.append("Error reading from file: " + ex.getMessage() + "\n");
            JOptionPane.showMessageDialog(this, "Error reading from file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ArtGalleryGUI();  // Start the GUI on the event dispatch thread
            }
        });
    }
}