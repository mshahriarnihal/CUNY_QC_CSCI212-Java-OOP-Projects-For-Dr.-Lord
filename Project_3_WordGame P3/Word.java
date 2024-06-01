/**
 * The Word class represents a word in the Word Puzzle game.
 * It encapsulates a word as a string (as it needs to be private) and provides methods to access and manipulate it.
 */
public class Word 
{
    private String word;

    /**
     * Constructs a Word object with the specified word.
     * Throws an IllegalWordException if the word contains characters other than lower-case letters.
     * @param word The word to be created as encapsulated.
     * @throws IllegalWordException If the word contains characters other than lower-case letters.
     */
    public Word(String word) throws IllegalWordException 
    {
        if (!word.matches("[a-z]+"))  /* Checks if the word contains only lower-case letters, if it doesn't, then throws an exception. */
        { 
            throw new IllegalWordException("Illegal word: " + word);
        }

        this.word = word;
    }

    /* This is the get method for word as "word" is private. */
    /**
     * Returns the encapsulated word.
     * @return The word.
     */
    public String getWord() 
    {
        return word;
    }

    /* Overriding the toString method here to use it in the PuzzleGUI class. */
    /**
     * Overrides the toString method to return the encapsulated word.
     * @return The encapsulated (private) word.
     */
    @Override
    public String toString() 
    {
        return word;
    }
}
