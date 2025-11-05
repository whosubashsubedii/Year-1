
/**
 *  Write a Java program that does the following:
  
     Retrieves a specific character at a given index in the string. 
     Finds the first occurrence of a user-specified character in the string.
     Checks if the string contains a given word and prints its index position.
 
         [ Hint: use indexOf() charAt() and contain() methods ]
 */

import java.util.Scanner;
public class Question_3
{
    public static void main (String[] args)
    {
        String name = "This is test";
        char c = name.charAt(2);
        System.out.println( c );
        
        //user specified character
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a character: ");
        
        char ch = sc.nextLine().charAt(0);
        System.out.println(name.indexOf(ch));
        
        // 
        boolean b = name.contains("Ab");
        System.out.println(b);
        
        sc.close();
    }
}
