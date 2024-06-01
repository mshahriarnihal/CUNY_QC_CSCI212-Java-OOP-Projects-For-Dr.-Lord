import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * The FileMenuHandler class handles file menu actions in the PuzzleGUI application to set specific actions.
 * It implements the ActionListener interface to respond to menu item clicks.
 */
public class FileMenuHandler implements ActionListener 
{
    private PuzzleGUI wordPuzzle;     // Reference to the PuzzleGUI object
    private Project3 theGame;         // Reference to the Project3 object

    /**
     * Constructs FileMenuHandler object.
     * Initializes the wordPuzzle reference with the given PuzzleGUI object and creates a new Project3 object.
     * @param wordPuzzle The PuzzleGUI object associated with this file menu handler.
     */
    public FileMenuHandler(PuzzleGUI wordPuzzle) 
    {
        this.wordPuzzle = wordPuzzle;
        theGame = new Project3();
    }


    /**
     * Performs actions based on the user's menu selections.
     * @param e The ActionEvent representing the user's action.
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand();
        if (command.equals("Open"))              // Triggers JFileChooser if user press "open" button in the menu bar's sub-menu "file".
        {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) 
            {
                File selectedFile = fileChooser.getSelectedFile();  // Stores the information of which file user has selected.
                String filename = selectedFile.getAbsolutePath();   /* Using getAbsolutePath() method to store the path of user's selected file as a string. */  
                theGame.inputFromFile(filename);                    /* Passes and calls the inputFromFile method of Project3 class to read and store solution from the selected file. */
                theGame.playGame2();                                /* Passes and calls the playGame2 method of Project3 class to start the main game. */
            }

        }

        else if (command.equals("Quit"))         // Terminates the program if user press "Quit" button from the menu.
        {
            System.exit(0);
        }
    }

}
