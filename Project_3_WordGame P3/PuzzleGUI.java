import javax.swing.*;
import java.awt.*;


/**
 * PuzzleGUI class represents the graphical user interface for the Word Puzzle game of Project 3.
 * It displays the subject letters to be used to guess words, user's score and the words they have found so far in alphabetical order. 
 * It also shows the menu bar with options to open a file for a new game and to quit the game.
 */
public class PuzzleGUI extends JFrame              // PuzzleGUI inherits the abilities of a JFrame.
{
    public TextArea textArea1 = new TextArea();    // Defining two textAreas to create two separate columns.
    public TextArea textArea2 = new TextArea();
    private SortedWordList guessedWords;

    JMenuBar menuBar = new JMenuBar();             // Creates the menu bar for the GUI

    /**
     * Constructs a PuzzleGUI object with the given subject letters and list of guessed words.
     * @param sevenLetters The subject letters to be used for guessing words.
     * @param guessedWords The list of correctly guessed words by the user.
     */
    public PuzzleGUI(String sevenLetters, SortedWordList guessedWords)     /* This constructor will be called in the "Project3" java file in order to start the game. */
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
        textArea1.append("Letters: " + sevenLetters);                      // Putting the puzzle's subject letters in the left column.
        textArea2.append("List of found words: \n");

        createFileMenu();

        setJMenuBar(menuBar);    

        setVisible(true);           // Makes the GUI visible.
    }

    /**
     * Creates the File menu in the menu bar with the sub-menu options
     * Sets what actions need to be done in response of pressing which options/buttons.
     */
    private void createFileMenu()   /* Creates the File menu in the menu bar with the sub-menu options and sets what actions need to be done for pressing which options. */
    {
        JMenuItem item;
        JMenu fileMenu = new JMenu("File");
        FileMenuHandler fmh = new FileMenuHandler(this);

        item = new JMenuItem("Open");         // Creates the "Open" button.
        item.addActionListener(fmh);          // Sets the action for "Open." 
        fileMenu.add(item);

        fileMenu.addSeparator();              // Adds a horizontal separator line.

        item = new JMenuItem("Quit");         // Creates the "Quit" button.
        item.addActionListener(fmh);          // Sets the action for "Quit."
        fileMenu.add(item);

        menuBar.add(fileMenu);
    }

    /* This method will be used to add a correctly guessed word to the sorted linked list named "guessedWords" to display the output and to be used further in the program. */
    /**
     * Adds a correctly guessed word to the list of guessed words and updates the GUI accordingly.
     * @param word The new word to be added.
     */
    public void addWord(String word) 
    {
        Word newWord = new Word(word);        /* While creating a new word, we don't need to use the try-catch statement here again. 
                                              Because, we are already using it inside Project3 class whereever it called "Word" and used "addWord" method. */
        if (!guessedWordsContains(newWord)) 
        {
            guessedWords.add(newWord);        // Adds the word to the sorted list.
            updateTextArea();
        }
    }

    /**
     * Shows the updated final score in the right column of the GUI.
     * @param totalScore The total score of the player to be displayed.
     */
    public void showScore(int totalScore)     // Shows updated final score in the right column.
    {
        textArea2.append("\nTotal Score: " + totalScore);
    }

    /* This method checks if a correctly guessed word is already guessed and got added to the sorted list. This method will be used inside "addWord()" method to prevent repetition. */
    /**
     * Checks if a correctly guessed word is already guessed before and added to the list of guessed words.
     * @param word The word which needs to be checked.
     * @return True if the word is already guessed, returns false otherwise.
     */
    private boolean guessedWordsContains(Word word) 
    {
        WordNode current = guessedWords.head.next;
        while (current != null)   /* While loop continues until it reaches the last word or the current word matches with any previously guessed word. */
        {
            if (word.getWord().equalsIgnoreCase(current.data.getWord())) 
            {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /* This method will be used to add new correctly guessed word alphabetically to the right column in the output. */
    /**
     * Updates the text area with the list of found words in alphabetical order.
     */
    private void updateTextArea() 
    {
        WordNode current = guessedWords.head.next;
        StringBuilder newText = new StringBuilder("List of found words: \n");

        while (current != null)     /* Adds words present in the sorted linked list named "guessedWords" to the "newText." */
        {
            newText.append(current.data.getWord()).append("\n");
            current = current.next;
        }

        textArea2.setText(newText.toString());    // Using setText and toString method to add "newText" to the right column (textArea2). "toString" is already overridden "Word.java" */
    }

    /**
     * Resets the text area in order to start a new game.
     */
    public void reset() // This method actually clears previously found words in order to start a new game.
    {
        textArea2.setText("List of found words: \n");
    }

}
