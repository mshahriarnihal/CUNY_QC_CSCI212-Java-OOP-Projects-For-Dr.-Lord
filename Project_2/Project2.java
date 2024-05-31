/* Student's Name: Mubasshir Al Shahriar
Lab Section:  Object Oriented Programming in Java CSCI 212 121C[34902]: Tue-Thu: 3:50 p.m (Professor Shu-Yuan Wu) */

import javax.swing.JOptionPane;

public class Project2 
{
    private String sevenLetters;
    private UnsortedWordList solutions;
    private SortedWordList guessedWords;
    private int score;

    /**
     * @author Mubasshir Al Shahriar (Nihal)
     */
    /* This constructor initializes the word game of Project 2 by reading input from a text file, initializes "solutions" and "guessedWords" as UnsortedWordList and SortedWordList to store necessary words, and sets the initial score to zero. */
    public Project2()   
    {
        solutions = new UnsortedWordList();
        guessedWords = new SortedWordList();
        inputFromFile("P1input.txt");
        score = 0;
    }


    public static void main(String[] args) 
    {
        Project2 wordGame = new Project2();
        wordGame.playGame();
    }


    public void playGame()   /* This method will prompt the user for their guesses and update the GUI and score accordingly. */
    {
        PuzzleGUI puzzleGUI = new PuzzleGUI(sevenLetters, guessedWords);

        while (true)         /* This while loop will keep asking the user to guess a word and check and take action comparing it with the solution until user press cancel. */
        {
            String guess = JOptionPane.showInputDialog(null, "Enter your guess:");

            if (guess == null) 
            {
                puzzleGUI.showScore(score);  // Shows the final score in the right column when users press cancel/end the game.
                break;                       // If the user clicks cancel button, the loop will be terminated, so, game will be ended.
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

            if (isCorrectGuess(guess))       // If the user guessed correct word, score gets updated based on game's rules.
            {
                score += (containsAllLetters(guess)) ? 3 : 1;  /* This conditional operator ensures to add +3 if correct word contains all letters of the hint, otherwise, adds 1 points. */
                puzzleGUI.addWord(guess);                      /* Adds the correctly guessed word in the GUI to display and adds the word on Sorted Linked List named "guessedWords." */

                JOptionPane.showMessageDialog(null, "Correct guess!");                
            }

            else 
            {
                JOptionPane.showMessageDialog(null, "Incorrect guess!");  // If the user makes a valid guess but the word doesn't match, then it will notify.
            }
        }

        JOptionPane.showMessageDialog(null, "Your final score is: " + score);
    }


    /* This method checks if the user has entered minimum number of letters, entered word that contains first letter of the subject letters, and used allowed letters only. */    
    private boolean isValidGuess(String guess) 
    {
        if (guess.length() < 5)  // If the user's input contains less than 5 letters, it will show them an error message.
        {
            JOptionPane.showMessageDialog(null, "Your guess must be at least 5 letters long!");
            return false;
        }

        guess = guess.toUpperCase();  /* Converting user's input and subject letters to upper case so that "indexOf" can be used to check if there is any invalid letters in the word */
        sevenLetters = sevenLetters.toUpperCase();

        if (guess.indexOf(sevenLetters.charAt(0)) == -1) /* Checks if the first letter of the subject letter is present anywhere in the guessed word. */
        {
            JOptionPane.showMessageDialog(null, "Your guess must contain the first letter of the subject letters!");
            return false;
        }

        for (char c : guess.toCharArray())   /* This for each loop goes over each letters of the guessed words and finds if there is any invalid letter. */
        {
            if (sevenLetters.indexOf(c) == -1) 
            {
                JOptionPane.showMessageDialog(null, "Your guess contains invalid letters!");
                return false;
            }
        }

        return true;
    }


    /* This method checks if the user's guess matches with any of the words present in the solutions file (UnsortedWordList). */
    private boolean isCorrectGuess(String guess) 
    {
        WordNode current = solutions.head.next;  /* Initializes current to head.next to set it to the first word as the actual first node (head) is a dummy node which is null. */

        while (current != null)   /* This while loop starts from first word of solution list & continues until finds null (reaches last word) or finds a matched word in solutions. */
        {
            if (guess.equalsIgnoreCase(current.data.getWord()))  /* If user's guessed word matches with any solutions' word, the method returns true. */
            {
                return true;
            }

            current = current.next;
        }

        return false;
    }


    /* This method checks if the user's guessed word contains all the subject letters, which is essential to determine if a user can get +3 points or not. */
    private boolean containsAllLetters(String guess) 
    {
        int totalValidLetters = 0;  // This variable keeps track of how many subject letters are present in a guessed word.
        for (int i = 0; i < sevenLetters.length(); i++) 
        {            
            guess = guess.toUpperCase();
            sevenLetters = sevenLetters.toUpperCase();
            char letter = sevenLetters.charAt(i);

            for (int j = 0; j < guess.length(); j++)
            {
                char guessedLetter = guess.charAt(j);

                if (letter == guessedLetter)  /* This checks if the subject letters are present in the guessed word. */
                {
                    totalValidLetters++;
                    break;                
                }

            }
        }

        return totalValidLetters == sevenLetters.length();  /* Returns true if input has all subject letters (number of subject letters in input = total number of subject letters). */
    }


    /* This method checks if a correctly guessed word is already guessed by the user. It checks if the input matches with any word in the Sorted Linked List named "guessedWords." */
    private boolean isGuessed(String guess) 
    {
        WordNode current = guessedWords.head.next;  /* Using .next to avoid the dummy node and start from the actual first word in the list. */
        while (current != null) 
        {
            if (guess.equalsIgnoreCase(current.data.getWord())) 
            {
                return true;
            }

            current = current.next;
        }

        return false;
    }


    /* This method reads necessary lines from the text file and stores/adds them in string and into linked list. */
    private void inputFromFile(String filename) 
    {
        TextFileInput in = new TextFileInput(filename);
        sevenLetters = in.readLine();       /* Reads and stores the hints/subject letters (first line of the file) in the string. */
        String line = in.readLine();        /* Reads and stores other lines (words) in string so that the string can be used to add those words to the unsorted linked list (solutions). */

        while (line != null)                /* This while loop continues until it adds all the words from input text file to the unsorted linked list named "solutions." */
        {
            solutions.add(new Word(line));
            line = in.readLine();
        }

        in.close();
    }
} 
// Closing Project2 class.
