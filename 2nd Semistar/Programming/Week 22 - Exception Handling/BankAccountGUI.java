import javax.swing.*;
import java.awt.*;
import java.util.*;

public class BankAccountGUI extends JFrame {
    private JTextField txtAccountNumber, txtAccountName, txtAmount;
    private JComboBox<String> dayCombo, monthCombo, yearCombo;
    private JComboBox<String> comboAccountType;
    private JButton btnCreate, btnDeposit, btnWithdraw, btnDisplay, btnClear;
    private ArrayList<BankAccount> accountList = new ArrayList<>();

    public BankAccountGUI() {
        setTitle("Bank Account GUI");
        setSize(700, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Account Details"));
        inputPanel.setBounds(20,20, 650, 220);
        inputPanel.setBackground(new Color(200, 230, 255));

        txtAccountNumber = new JTextField();
        txtAccountName = new JTextField();
        txtAmount = new JTextField();

        // ComboBoxes for date
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) days[i-1] = String.valueOf(i);
        dayCombo = new JComboBox<>(days);

        String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        monthCombo = new JComboBox<>(months);

        String[] years = new String[50];
        for (int i = 0; i < 50; i++) years[i] = String.valueOf(1980 + i);
        yearCombo = new JComboBox<>(years);

        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        datePanel.add(dayCombo);
        datePanel.add(monthCombo);
        datePanel.add(yearCombo);
        datePanel.setBackground(new Color(200, 230, 255));

        comboAccountType = new JComboBox<>(new String[]{"Select","Savings", "Current", "Fixed Deposit"});

        inputPanel.add(new JLabel("Account Number:"));
        inputPanel.add(txtAccountNumber);
        inputPanel.add(new JLabel("Account Holder Name:"));
        inputPanel.add(txtAccountName);
        inputPanel.add(new JLabel("Registration Date:"));
        inputPanel.add(datePanel);
        inputPanel.add(new JLabel("Account Type:"));
        inputPanel.add(comboAccountType);
        inputPanel.add(new JLabel("Amount:"));
        inputPanel.add(txtAmount);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 10, 0));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));
        buttonPanel.setBounds(20, 250, 650, 70);
        btnCreate = new JButton("<html>Create <br>Account</html>");
        btnDeposit = new JButton("Deposit");
        btnWithdraw = new JButton("Withdraw");
        btnDisplay = new JButton("Display");
        btnClear = new JButton("Clear");

        btnCreate.setBackground(new Color(102, 153, 255));
        btnDeposit.setBackground(new Color(102, 204, 153));
        btnWithdraw.setBackground(new Color(255, 153, 51));
        btnDisplay.setBackground(new Color(102, 153, 204));
        btnClear.setBackground(Color.LIGHT_GRAY);

        buttonPanel.add(btnCreate);
        buttonPanel.add(btnDeposit);
        buttonPanel.add(btnWithdraw);
        buttonPanel.add(btnDisplay);
        buttonPanel.add(btnClear);

        add(inputPanel);
        add(buttonPanel);

        // Event Handlers
        

        setVisible(true);
    }

    public static void main(String[] args) {
        new BankAccountGUI();
    }
}
