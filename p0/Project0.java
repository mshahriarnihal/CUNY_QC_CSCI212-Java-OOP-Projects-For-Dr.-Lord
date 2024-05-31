//Student's Name: Mubasshir Al Shahriar
//Lab Section:  Object Oriented Programming in Java CSCI 212 121C[34902]: Tue-Thu: 3:50 p.m


/**
 * @author Mubasshir Al Shahriar (Nihal)
 */
import javax.swing.JOptionPane;	//imports JOptionPane header

public class Project0 
{
    public static void main(String[] args) 
    {	

        while(true)	//infinite loop that continues until it go over all the characters of input sentence and count lower and upper case "e."
        {
            String Sentence = JOptionPane.showInputDialog("Please enter a sentence: ");

            if(Sentence == null || Sentence.equalsIgnoreCase("Stop"))	//program stops if user types "Stop" in the input.
                System.exit(0);

            int lower_e=0, upper_E=0;	//initialing two integers to count and store total number of upper & lower case e.

            for(int i = 0; i < Sentence.length(); i++)	//this for loop check all the characters and finds out all the "E" and "e" in the sentence.
            {
                if(Sentence.charAt(i)=='E')	
                    upper_E++;              //increments total number of upper case e if an upper case e is found at particular position.

                else if(Sentence.charAt(i)=='e')
                    lower_e++;              //increments total number of lower case e if an lower case e is found at particular position.
            }

            JOptionPane.showMessageDialog(null, "Number of lower case e's: " + lower_e +"\nNumber of upper case e's: " + upper_E);	//Output dialog box to show the result.

        }	
    }
}
