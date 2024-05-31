/* Student's Name: Mubasshir Al Shahriar
Lab Section:  Object Oriented Programming in Java CSCI 212 121C[34902]: Tue-Thu: 3:50 p.m (Professor Shu-Yuan Wu) */


import java.io.File;
import java.util.TreeMap;
import javax.swing.JFileChooser;

/**
 * @author Mubasshir Al Shahriar (Nihal)
 */
/**
 * This program reads a text file, then separately stores its each words with treemap, and counts how many times each of those words occured,
 * and finally displays those words along with their counts in alphabetical order.
 */
public class Project4 
{
    public static void main(String[] args) 
    {        
        TreeMap<String, Integer> wordCounts = new TreeMap<>();          // This creates a TreeMap to store words and their counts.

        JFileChooser fileChooser = new JFileChooser();                  // Using JFileChooser to allow the user to select the input file they want to check.
        int decision = fileChooser.showOpenDialog(null);

        if (decision == JFileChooser.APPROVE_OPTION)                      /* If the user selects a file, the program proceeds with reading and processing it. */
        {
            File selectedFile = fileChooser.getSelectedFile();                  /* Stores the path of the text file that the user has selected. */
            TextFileInput in = new TextFileInput(selectedFile.getPath());       /* Calling "TextFileInput" class which reads texts from a text file. */
            String line;

            while ((line = in.readLine()) != null)                      /* This while loop goes through all the lines of the text file and reads each line. */
            {                
                String[] words = line.split("\\W+");                    // Tokenizing each words using split method and regular expression.

                for (String word : words)                               /* Counting the occurrences of each word and update the TreeMap using for each loop. */ 
                {
                    if (!word.isEmpty()) 
                    {
                        wordCounts.put(word.toLowerCase(), wordCounts.getOrDefault(word.toLowerCase(), Integer.valueOf(0)) + 1);   /* Here using the wrapper class Integer to hold the count of the words as TreeMaps do not store primitives. */
                    }
                }
            }

            in.close();

            wordCounts.forEach((word, count) -> System.out.println(word + " - " + count));    /* This line of code iterates over each entry in the TreeMap (wordCounts) and prints each word alphabetically  along with its number of occurence. */

        }

        else 
        {
            System.out.println("Exiting program as you did not select any file to check.");   /* If user press "Cancel" and does not select any file, the program terminates and shows message. */
        }
    }

}  // Closing Project4 class.      
