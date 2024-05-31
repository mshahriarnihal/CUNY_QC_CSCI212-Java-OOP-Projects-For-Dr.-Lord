import javax.swing.*;
import java.awt.*;

/* PuzzleGUI class represents the graphical user interface for the Word Puzzle game of Project 1.
  It displays the letters to be used to guess words, user's score and the words they have found so far. */

public class PuzzleGUI extends JFrame             // PuzzleGUI will inherit the abilities of a JFrame.
{
    public TextArea textArea1 = new TextArea();   // Defining two textAreas to create two separate columns. 
    public TextArea textArea2 = new TextArea();

    public PuzzleGUI(String sevenLetters)         // This constructor will be called in the "Project1" java file. 
    {
        setTitle("Word Puzzle Game");   
        setSize(400, 300);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));
        Container myContentPane = getContentPane();
        myContentPane.add(textArea1);
        myContentPane.add(textArea2);

        textArea1.append("Letters: " + sevenLetters);      // Putting the puzzle letters in the left column.
        textArea2.append("List of found words: \n");       // Putting the score in the right column. 

        setVisible(true);    //Makes the GUI visible.
    }

    public void addWord(String word) 
    {
        textArea2.append(word + "\n");   // In the right column, putting the list of matched words the user has found so far.
    }

    public void showScore(int totalScore) 
    {
        textArea2.append("\nTotal Score: " + totalScore);   // In the right column, printing the final score.
    }

} // Closing PuzzleGUI class.