import java.io.*;

public class FileHandling {
    public static void main(String[] args) {
        File f = new File("example.txt");

        try {
            if (f.exists()) {
                System.out.println("File already exists");
            } else {
                if (f.createNewFile()) { // creates file
                    System.out.println("File Created");
                    System.out.println("Absolute Path: " + f.getAbsolutePath());
                } else {
                    System.out.println("File could not be created");
                }
            }
        } catch (Exception e) {
            System.out.println("Error in file operation: " + e.getMessage());
        }
    }
}
