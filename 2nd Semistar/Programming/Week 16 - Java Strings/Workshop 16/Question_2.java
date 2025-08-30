
/**
 *  Write a Java program that performs the following operations on a given string:
  
     Removes any leading and trailing whitespace. 
     Extracts a substring containing only the first 10 characters.
     Splits the string into a list of words and prints them individually.

         [ Hint: use trim(), substr() and split() methods ]
 */

import java.util.Scanner;
public class Question_2
{
    public static void main (String[] args)
    {
        String sample = " This is Sample String ";
        System.out.println(sample);
        
        String newsample = sample.trim();
        System.out.println(newsample);
        
        // extract a substring containing first 10 characters;
        
        if(newsample.length() >= 10)
        {
            String part = newsample.substring(0,10);
            System.out.println(part);
        }else{
            String part = newsample.substring(0);
            System.out.println(part);
        }
        
        // Splits the string
        
        String[] arr = newsample.split(" ");
        // for-each loop
        
        for(String a : arr)
        {
            System.out.println(a);
        }
    }
        
        
        
        
        
    
}
