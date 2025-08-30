
/**
 * Write a program that performs the following operations: 

 
    Takes two input strings from the user.
    Concatenates (combines) the two strings into a single string. 
    Compares the combined string with a third input string.)
    
    [Hint: use concat() and equal() method
 */


import java.util.Scanner;
public class Question_1{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner (System.in);
        System.out.print ("Enter first string value:");
        String firstString = sc.nextLine(); // yesma chai First user bata input lena 
        
        System.out.print ("Enter the second string value:");
        String secondString = sc.nextLine(); // yes ma hami lai second input lenaxam
        
        String combinedString = firstString.concat(secondString); // .concat this used to join or add
        System.out.println("The Combined strings is: " + combinedString);
        
        System.out.print("Enter the third string: ");
        String thirdString = sc.nextLine(); // reading anotehr string
        
        if(combinedString == thirdString) // yesm chai string lai compare garxa 
        {
            System.out.println("The two string are equal");
        } else
        {
            System.out.println("The two String are not equal");
        }
    }
}
