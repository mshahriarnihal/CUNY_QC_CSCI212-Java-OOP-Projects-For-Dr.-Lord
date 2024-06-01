/* Student's Name: Mubasshir Al Shahriar
Lab Section:  Object Oriented Programming in Java CSCI 212 121C[34902]: Tue-Thu: 3:50 p.m (Professor Shu-Yuan Wu) */


import javax.swing.*;


/**
 * This project extends Project 2. 
 * In Project 2, the user could play word game where they needed to guess word built with certain subject letters.
 * If they could guess one, they got +1 point, if their guessed word contained all subject letters, they got +3.
 * They could see their score and their correctly guessed words in alphabetical order in the right column of the GUI, and subject letters at left.
 * They had several conditions to meet while guessing: they must use first subject letter, the minimum length of word must be 5.
 * Project 3 keeps all those conditions and features from Project 2 with some extended features.
 * Project 3 congratulates the player if he or she wins the game by guessing all the words on the solutions list.
 * Then asks if he or she would like to play again and takes action based on their responses.
 * In Project 3, the user can choose the input file which they want to use to play this game through option from file menu. They can also end the game by clicking "Quit."
 * If a Word is illegal (does not contain all lower-case letters), an exception called IllegalWordException is thrown. 
 * @author Mubasshir Al Shahriar (Nihal)
 */
public class Project3 
{
    private String sevenLetters;
    private UnsortedWordList solutions;
    private SortedWordList guessedWords;
    private int score;


    /* This constructor initializes "solutions" and "guessedWords" as UnsortedWordList and SortedWordList to store necessary words, and sets the initial score to zero. */
    /**
     * Constructs a Project3 object.
     * Calls UnsortedWordList and SortedWordList class to initialize necessary variables.
     */
    public Project3() 
    {
        solutions = new UnsortedWordList();
        guessedWords = new SortedWordList();

        score = 0;
    }


    /**
     * The main method of the application.
     * Instantiates a Project3 object and starts the game.
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) 
    {
        Project3 wordGame = new Project3();
        wordGame.playGame();
    }


    /* This method is used to be called in the main to further call the PuzzleGUI so that, the interface pops up and user can select a file to start the word game. */
    /**
     * Starts the word guessing game.
     * Displays the user interface and allows the user to select a file in order to start the game.
     */
    public void playGame() 
    {        
        PuzzleGUI puzzleGUI = new PuzzleGUI(sevenLetters, guessedWords);
    }

    /* The main game starts with this method */
    /**
     * Continues the program and main game starts.
     * Asks the user to guess and updates the game accordingly until the user cancels or guesses all words.
     */
    public void playGame2() 
    {       
        PuzzleGUI puzzleGUI = new PuzzleGUI(sevenLetters, guessedWords);

        while (true)   /* This while loop will keep asking the user to guess word and will check & take action comparing it with solution until user press cancel or guess all words. */
        {
            String guess = JOptionPane.showInputDialog(null, "Enter your guess:");

            if (guess == null) 
            {
                puzzleGUI.showScore(score);     // Shows the final score in the right column when the game ends.
                break;                          // If the user clicks cancel button, the loop will be terminated, so, game will be ended.
            }


            if (!isValidGuess(guess))           // If the user uses invalid letters or less than five letters, then they will be notified.
            {
                JOptionPane.showMessageDialog(null, "Invalid guess!");
                continue;
            }


            if (isGuessed(guess))               // If the user already entered the correct word before, then it will notify and won't increase the score.
            {
                JOptionPane.showMessageDialog(null, "You already guessed this and got point(s) for it!");
                continue;
            }

            if (isCorrectGuess(guess))          // If the user guessed correct word, score gets updated based on game's rules.
            {

                try   /* Before adding score, this try/catch statement makes sure user's word doesn't contain capital letter, as the instruction says, word with upper-case is illegal */
                {                
                    puzzleGUI.addWord(guess);   /* If everything is ok, calls the addWord method to add the word on sorted linked list named "guessedWords" and show it through the GUI. */
                    score += (containsAllLetters(guess)) ? 3 : 1;   /* Conditional operator to ensures +3 if correct word contains all subject letters (hint), otherwise, adds 1 points. */
                    JOptionPane.showMessageDialog(null, "Correct guess!");
                }

                catch (IllegalWordException e) /* If any illegal exception is found, the erroneous guessed word will be showed in the console and also through pop-up message. */ 
                {
                    JOptionPane.showMessageDialog(null, "Your word is illegal as it doesn’t contain all lower-case letters." + e.getMessage());
                    System.out.println("User's word is illegal as it doesn’t contain all lower-case letters." + e.getMessage());
                }

                if (solutions.getLength() == guessedWords.getLength()) /* If user guesses all the words, they will be congratulated and asked to choose further option. */ 
                {
                    JOptionPane.showMessageDialog(null, "Congratulations! You've guessed all the words! Your Score: " + score);

                    if (JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) 
                    {
                        JOptionPane.showMessageDialog(null, "Thanks for playing. Your final score is: " + score);
                        puzzleGUI.showScore(score);      /* If the user doesn't want to play again, final score will be shown and the while loop comes to an ends to stop the game. */
                        break;
                    }

                    else                        /* If user wants to play again, score and right sided text area gets reset, which means, the game starts again. */
                    {
                        score = 0;
                        guessedWords.clear();
                        puzzleGUI.reset();
                    }
                }

            }

            else 
            {
                JOptionPane.showMessageDialog(null, "Incorrect guess!");     // If the user makes a valid guess but the word doesn't match, then it will notify.
            }
        }
    }


    /* This method checks if the user has entered minimum number of letters, entered word that contains first letter of the subject letters, and used allowed letters only. */
    /**
     * Checks if a guessed word is valid.
     * A valid guess must have at least 5 letters, contain the first subject letters, and use only subject letters.
     * @param guess The word guessed by the user.
     * @return True if the guess is valid, otherwise it gives false.
     */
    private boolean isValidGuess(String guess) 
    {
        if (guess.length() < 5)    // If the user's input contains less than 5 letters, it will show them an error message.
        {
            JOptionPane.showMessageDialog(null, "Your guess must be at least 5 letters long!");
            return false;
        }

        guess = guess.toUpperCase();    /* Converting user's input and subject letters to upper case so that "indexOf" can be used to check if there is any invalid letters in the word */
        sevenLetters = sevenLetters.toUpperCase();

        if (guess.indexOf(sevenLetters.charAt(0)) == -1)    /* Checks if the first letter of the subject letter is present anywhere in the guessed word. */
        {
            JOptionPane.showMessageDialog(null, "Your guess must contain the first letter of the subject letters!");
            return false;
        }

        for (char c : guess.toCharArray())  /* This for each loop goes over each letters of the guessed words and finds if there is any invalid letter. */
        {
            if (sevenLetters.indexOf(c) == -1) 
            {
                JOptionPane.showMessageDialog(null, "Your guess contains invalid letters!");
                return false;
            }
        }

        return true;
    }


    /* This method checks if the user's guess matches with any of the words present in the solution's file (UnsortedWordList). */
    /**
     * Checks if a guessed word is correct.
     * @param guess The word guessed by the user.
     * @return True if the guess matches any word in the solutions list, otherwise false.
     */
    private boolean isCorrectGuess(String guess) 
    {
        WordNode current = solutions.head.next;    /* Initializes current to head.next to set it to the first word, as the actual first node (head) is a dummy null node. */
        while (current != null)                    /* This loop starts from first word of list & continues until finds null (reaches last word) or finds a matched word in solutions. */
        {
            if (guess.equalsIgnoreCase(current.data.getWord()))   /* If user's guessed word matches with any solutions' word, the method returns true. */
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    /* This method checks if the user's guessed word contains all the subject letters, which is essential to determine if a user can get +3 points or not. */
    /**
     * Checks if user's guessed word contains all subject letters.
     * @param guess The word guessed by the user.
     * @return True if the word contains all subject letters, false otherwise.
     */
    private boolean containsAllLetters(String guess) 
    {
        int totalValidLetters = 0;                            /* This variable keeps track of how many subject letters are present in a guessed word. */
        for (int i = 0; i < sevenLetters.length(); i++) 
        {
            guess = guess.toUpperCase();
            sevenLetters = sevenLetters.toUpperCase();
            char letter = sevenLetters.charAt(i);

            for (int j = 0; j < guess.length(); j++) 
            {
                char guessedLetter = guess.charAt(j);
                if (letter == guessedLetter)                  /* This checks if the subject letters are present in the guessed word. */
                {
                    totalValidLetters++;
                    break;
                }
            }
        }

        return totalValidLetters == sevenLetters.length();    /* Returns true if input has all subject letters (number of subject letters in input = total number of subject letters). */
    }

    /* This method checks if a correctly guessed word is already guessed by the user. It checks if the input matches with any word in the Sorted Linked List named "guessedWords." */
    /**
     * Checks if a correctly guessed word has already been guessed before to prevent repetition.
     * @param guess The word guessed by the user.
     * @return True if the word has already been guessed, false otherwise.
     */
    private boolean isGuessed(String guess) 
    {
        WordNode current = guessedWords.head.next;            /* Using .next to avoid the dummy node and start from the actual first word in the list. */
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


    /* This method checks the validity of guessed words (length, first subject letter, valid character) just like "isValidGuess()" method. But unlike isValidGuess(), this method doesn't show any pop-up error essage to notify. It just returns true or false. We need this method to use it in "inputFromFile()" method to keep the program looking user-friendly. */
    /**
     * Checks if a word is valid or not.
     * A valid word must have at least 5 letters, contain the first letter of the subject letters, and use only allowed letters.
     * This method is same as "isValidGuess" method, but this one won't show any pop-up message.
     * This method is used to validate words read from a file.
     * @param guess The word to check validity.
     * @return True if the word is valid, otherwise returns false.
     */
    private boolean validOrNot(String guess) 
    {
        if (guess.length() < 5) 
        {
            return false;
        }

        guess = guess.toUpperCase();
        sevenLetters = sevenLetters.toUpperCase();

        if (guess.indexOf(sevenLetters.charAt(0)) == -1) 
        {   
            return false;
        }

        for (char c : guess.toCharArray()) 
        {
            if (sevenLetters.indexOf(c) == -1)  // Checks if the word has valid characters (subject letters) only.
            {
                return false;
            }
        }

        return true;
    }



    /* This method reads necessary lines from the text file and stores/adds them if they are valid and legal. */
    /**
     * Reads words from a file (line by line) and adds them to the solutions list if they are valid and legal.
     * @param filename The name of the file to read words from.
     * @throws IllegalWordException if an illegal word is encountered in the file.
     */
    public void inputFromFile(String filename) 
    {
        TextFileInput in = new TextFileInput(filename);
        sevenLetters = in.readLine();   /* Reads and stores the hints/subject letters (first line of the file) in the string. */
        String line = in.readLine();    /* Reads and stores other lines (words) in string so that that string can be used to add those words to unsorted linked list (solutions). */

        while (line != null)            /* This while loop continues until it adds all the valid words from input text file (selected by user) to the UnsortedWordList named "solutions." */
        { 

            try  /* This try-catch statement will find & throw exception for illeagl words (doesn't contain all lower-case letters) & prevent adding them from input text to "solutions." */ 
            {

                Word word = new Word(line); /* Creates the new "word" with string "line" that contains a correctly guessed word. Try/catch makes sure it contains all lower-case letters */

                if(validOrNot(line))
                {
                    solutions.add(new Word(line));
                }

            }

            /* If it catches an illegal word exception in the program, it shows the erroneous Words in the console. It also notifies the user through a pop-up message. */
            catch (IllegalWordException e)   
            {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                System.out.println("Error: " + e.getMessage());   //Prints the erroneous Words in the console.
            }

            line = in.readLine();

        }

        in.close();
    }
}
// Closing Project3 class.