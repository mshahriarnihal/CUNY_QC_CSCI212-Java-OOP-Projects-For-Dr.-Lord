/* Student's Name: Mubasshir Al Shahriar
Lab Section:  Object Oriented Programming in Java CSCI 212 121C[34902]: Tue-Thu: 3:50 p.m (Professor Shu-Yuan Wu) */


import javax.swing.JOptionPane;
import java.util.StringTokenizer;

/**
 * @author Mubasshir Al Shahriar (Nihal)
 */
public class Project1 
{
    private String sevenLetters;
    private String[] solutions;
    private int score;
    private String[] guessed;

    public Project1()  /* This constructor will initialize the word game by reading input from a text file and set the initial score to zero. */
    {
        inputFromFile("P1input.txt");
        score = 0;
    }

    public static void main(String[] args)  
    {
        Project1 wordGame = new Project1();
        wordGame.playGame();
    }

    public void playGame()   /* This method will prompt the user for their guesses and update the GUI and score accordingly. */
    {
        PuzzleGUI puzzleGUI = new PuzzleGUI(sevenLetters);
        int totalLineNum = totalLine("P1input.txt");
        guessed = new String[totalLineNum];
        int countGuessed = 0;

        /* This while loop will keep asking the user to guess word and check and take action comparing it with the solution until user press cancel. */
        while (true)  
        {
            String guess = JOptionPane.showInputDialog(null, "Enter your guess:");  // Takes the guessing input from the user.

            if (guess == null) 
            {
                puzzleGUI.showScore(score);  // Shows the final score in the right column when users press cancel/end the game.
                break;                       // If the user clicks cancel button, the loop will be terminated, so, game will be ended, user will get their final score.
            }

            if (!isValidGuess(guess))        // If the user uses invalid letters or less than five letters, then they will be notified.
            {
                JOptionPane.showMessageDialog(null, "Invalid guess!");
                continue;    
            }

            if (isGuessed(guess))            // If the user already entered the correct word before, then it will notify and won't increase the score.
            {
                JOptionPane.showMessageDialog(null, "You already guessed this and scored 1 point!");
                continue;    
            }

            if (isCorrectGuess(guess))            
            {
                score++;                          // Score increases as the user guessed one correct word.
                puzzleGUI.addWord(guess);         // Adding the correctly guessed word in the GUI.
                guessed[countGuessed++] = guess;  // Adding the correctly guessed word in the list of already guessed words to prevent repetition.
                JOptionPane.showMessageDialog(null, "Correct guess!");
            }

            else 
            {
                JOptionPane.showMessageDialog(null, "Incorrect guess!");   // If the user makes word with valid letters but the word doesn't match, then they will be notified.
            }
        }

        JOptionPane.showMessageDialog(null, "Your final score is: " + score);  
    }

    private boolean isValidGuess(String guess) /* This method will check if the user has entered minimum number of letters and used word with allowed letters only. */
    {
        if (guess.length() < 5) // If the user's input contains less than 5 letters, it will show them an error message.
        {
            JOptionPane.showMessageDialog(null, "Your guess must be at least 5 letters long!");
            return false;
        }

        guess = guess.toUpperCase();  /* Converting user's input and puzzle letters to upper case so that the "indexOf" can be used to check if their is any invalid letters in the word */
        sevenLetters = sevenLetters.toUpperCase();
        for (char c : guess.toCharArray()) 
        {  
            if (sevenLetters.indexOf(c) == -1) 
            {
                JOptionPane.showMessageDialog(null, "Your guess contains invalid letters!");
                return false;
            }
        }
        return true;
    }

    /* This method checks if the user's guess matches with any of the words present in the solution file. */
    private boolean isCorrectGuess(String guess) 
    {
        for (String solution : solutions)   // Using for each loop to compare the user's guess and all the solution words in each line of the text file.
        {             
            if (guess.equalsIgnoreCase(solution))  
            {
                return true;
            }
        }
        return false;
    }

    /* This method checks if a correctly guessed word is already guessed by the user before. */
    private boolean isGuessed(String guess) 
    {
        for (String matchGuess : guessed) 
        {             
            if (guess.equalsIgnoreCase(matchGuess)) 
            {
                return true;
            }
        }
        return false;
    }

    /* This method counts total number of solution words (total line - 1, as the first line is for hint only) in the text file. */
    private int totalLine(String filename) 
    {
        TextFileInput inp = new TextFileInput(filename);
        String line = inp.readLine(); 
        int count = 0;
        while (line != null)  // Counts the total number of lines (except the first line).
        {
            count++;
            line = inp.readLine();
        }

        inp.close();
        return count;
    }

    /* This method reads necessary lines from the text file. */
    private void inputFromFile(String filename)   
    {
        TextFileInput in = new TextFileInput(filename);
        sevenLetters = in.readLine();      // Reads and stores the first line of the file to show it as the list of letters to be used.
        int lineNum = totalLine(filename);
        solutions = new String[lineNum];   
        int index = 0;       
        solutions[index] = in.readLine();  // Reads and stores the other lines as solutions to check if the user's guess matches with any of these.

        while (solutions[index] != null)  // This while continues until it puts all the words from solution file to the array named "solutions."
        {
            solutions[++index] = in.readLine();  
        }

        in.close();
    }
}     // Closing Project1.
