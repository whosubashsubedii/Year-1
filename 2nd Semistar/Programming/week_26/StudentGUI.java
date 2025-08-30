import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class StudentGUI {
    private JFrame frame;
    private JTextField rollNoField, nameField;
    private JComboBox<String> gradeBox;
    private JButton addBtn, displayBtn, saveBtn, readBtn;
    private ArrayList<Student> studentList = new ArrayList<>();

    public StudentGUI() {
        try (
            
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream("student.dat"));
            while (true){
            try{
                Object o  = o1.readObject(); 
                Student s = (Student) o;
                studentList .add(s);
            }catch{EOFException ef){
                break;
            }
                JOptionPane.showMessageDialog(null,"Load Complete");
            }
            }
        )
        
        
        
        frame = new JFrame("Student Management");
        frame.setSize(600, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel rollNoLabel = new JLabel("Roll No:");
        rollNoLabel.setBounds(20, 20, 80, 25);
        frame.add(rollNoLabel);

        rollNoField = new JTextField();
        rollNoField.setBounds(100, 20, 150, 25);
        frame.add(rollNoField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 60, 80, 25);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 60, 150, 25);
        frame.add(nameField);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setBounds(20, 100, 80, 25);
        frame.add(gradeLabel);

        gradeBox = new JComboBox<>(new String[]{"A", "B", "C", "D", "F"});
        gradeBox.setBounds(100, 100, 150, 25);
        frame.add(gradeBox);

        addBtn = new JButton("Add");
        addBtn.setBounds(300, 20, 100, 25);
        frame.add(addBtn);

        displayBtn = new JButton("Display");
        displayBtn.setBounds(300, 60, 100, 25);
        frame.add(displayBtn);

        saveBtn = new JButton("Save");
        saveBtn.setBounds(300, 100, 100, 25);
        frame.add(saveBtn);

        readBtn = new JButton("Read");
        readBtn.setBounds(300, 140, 100, 25);
        frame.add(readBtn);

        // Add Button Action
        addBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        int rollNo = Integer.parseInt(rollNoField.getText());
                        String name = nameField.getText();
                        String grade = (String) gradeBox.getSelectedItem();

                        if(name.isEmpty() || grade.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Please fill all the fields", "Warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        for(Student s : studentList){
                            if(rollNo == s.getRollNo()){
                                JOptionPane.showMessageDialog(null,"Student already exists", "Warning", JOptionPane.WARNING_MESSAGE);
                                return; 
                            }
                        }

                        Student s = new Student(rollNo, name, grade);
                        studentList.add(s);

                        JOptionPane.showMessageDialog(frame, "Student added!");
                        rollNoField.setText("");
                        nameField.setText("");
                        gradeBox.setSelectedIndex(0);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Enter numeric value for Roll No!");
                    }
                }
            });

        // Display Button Action
        displayBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String[] columns = {"Roll No", "Name", "Grade"};
                    DefaultTableModel model = new DefaultTableModel(columns, 0);
                    for (Student s : studentList){
                        Object[] row = {s.getRollNo(), s.getName(), s.getGrade()};
                        model.addRow(row);
                    }
                    JTable table = new JTable(model);

                    JScrollPane scrollPane = new JScrollPane(table);

                    JDialog dialog = new JDialog();
                    dialog.add(scrollPane);
                    dialog.setSize(400,400);
                    dialog.setVisible(true);

                }
            });

        saveBtn.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    // file handling 
                    try {
                        //bufferWriter object
                        File f = new File("student.txt");   // yesko kam file ko location denxa 
                        BufferedWriter bw = new BufferedWriter (new FileWriter(f));     // yesko kam file new file create garxa 
                        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("student.dat"));
                        System.out.println(f.getAbsolutePath());
                        String header = String.format("%-6s %-10s %-5s","RollNo", "Name", "Grade"); // sapce dena kam garxa Rollno ane 6 yota space denxa ane Name ma 10 xa 10 ko space denxa
                        bw.write(header + "\n");               
                        bw.write("=".repeat(30) + "\n");        //yesko kam 15 == denxa 

                        for (Student s : studentList){      // yesma Student class ma vaye ko lai call gareko xa  
                            os.writeObject(s);
                            int roll = s.getRollNo();
                            String name = s.getName();
                            String grade = s.getGrade();
                            String row = String.format("%-6s %-10s %-5s", roll ,name, grade);
                            bw.write(row);  // yesma kea hunxa vane first ma roll number aauxa then comma ane name aauxa ane comma ane grade aauxa 
                            bw.newLine();       // yesko kam same line ma data xa vane another ma shift gardenxa 
                        }
                        bw.close();         // yesko kam write gare paxe closed garne kam garxa 
                        JOptionPane.showMessageDialog (null,"Data saved to file:"+ f.getAbsolutePath());

                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Error while writting to file ");
                    }
                }
            }

        );
        
        readBtn.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{
                        //bufferReader
                        File f = new File("student.txt");
                        BufferedReader br = new BufferedReader(new FileReader(f));
                        String line;
                        StringBuilder sb = new StringBuilder();
                        while ((line = br.readLine()) != null){
                            sb.append(line).append("\n");
                            
                        }
                        
                        JTextArea txt = new JTextArea();
                        txt.setText(sb.toString());
                        txt.setEditable(false);
                        JScrollPane s = new JScrollPane(txt);
                        
                        JDialog  dialog = new JDialog();
                        dialog.setSize(600,600);
                        dialog.add(s);
                        dialog.setVisible(true);
                    }
                    catch (Exception ex){
                        
                    System.out.println("Expection");
                
                }
            }
        }
        
        );
        
        
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new StudentGUI();
    }

}
