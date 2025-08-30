import java.io.*;
public class FileHandling1
{
    public static void main(String[] args)
    {
        //write 
        try
        {
            FileWriter writer = new FileWriter("example1.txt", true);
            writer.write("My name is example");
            writer.close();
        }catch(Exception e)
        {
            System.out.println("ERRORRRRRRR.");
        }
    }
}