import java.io.*;

public class FileWriterExample {
    public static void main(String[] args) {
        String[] names = {"ABC", "DEF", "GHI", "JKL"};

        try {
            // File write
            FileWriter w = new FileWriter("example2.txt");
            for (String n : names) {
                w.write("My name is " + n + ".\n");
            }
            w.close();
            System.out.println("Written Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileReader reader = new FileReader("example.txt");
            BufferedReader b = new BufferedReader(reader);
            String line;
            while ((line = b.readLine()) != null) {
                System.out.println(line);
            }
            b.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
