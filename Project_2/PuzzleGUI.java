import javax.swing.*;
import java.awt.*;

/* PuzzleGUI class represents the graphical user interface for the Word Puzzle game of Project 2.
  It displays the subject letters to be used to guess words, user's score and the words they have found so far in alphabetical order. */

public class PuzzleGUI extends JFrame            // PuzzleGUI will inherit the abilities of a JFrame.
{
    public TextArea textArea1 = new TextArea();  // Defining two textAreas to create two separate columns.
    public TextArea textArea2 = new TextArea();
    private SortedWordList guessedWords;

    public PuzzleGUI(String sevenLetters, SortedWordList guessedWords)   // This constructor will be called in the "Project2" java file.
    {
        this.guessedWords = guessedWords;
        setTitle("Word Puzzle Game");
        setSize(400, 300);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        Container myContentPane = getContentPane();
        myContentPane.add(textArea1);
        myContentPane.add(textArea2);

        textArea1.append("Letters: " + sevenLetters);        // Putting the puzzle's subject letters in the left column.
        textArea2.append("List of found words: \n");     

        setVisible(true);    //Makes the GUI visible.
    }


    /* This method will be used to add a correctly guessed word to the sorted linked list named "guessedWords" to display the output and to be used further in the program. */
    public void addWord(String word) 
    {
        Word newWord = new Word(word);

        if (!guessedWordsContains(newWord)) 
        {
            guessedWords.add(newWord); // Adds the word to the sorted list.
            updateTextArea();
        }
    }


    public void showScore(int totalScore) 
    {
        textArea2.append("\nTotal Score: " + totalScore);
    }


    /* This method checks if a correctly guessed word is already guessed and got added to the sorted list. This method will be used inside "addWord()" method to prevent repetition. */ 
    private boolean guessedWordsContains(Word word) 
    {
        WordNode current = guessedWords.head.next;

        while (current != null) 
        {
            if (word.getWord().equalsIgnoreCase(current.data.getWord())) 
            {
                return true;
            }

            current = current.next;
        }

        return false;
    }


    /* This method will be used to add new correctly guessed word to the right column in the output. */
    private void updateTextArea() 
    {
        WordNode current = guessedWords.head.next;
        StringBuilder newText = new StringBuilder("List of found words: \n");

        while (current != null) /* Adds words present in the sorted linked list named "guessedWords" to the "newText." */ 
        {
            newText.append(current.data.getWord()).append("\n");
            current = current.next;
        }

        textArea2.setText(newText.toString());  // Using setText and toString method to add "newText" to the right column (textArea2). "toString" is already overridden "Word.java" */ 
    }
}
// Closing PuzzleGUI class.