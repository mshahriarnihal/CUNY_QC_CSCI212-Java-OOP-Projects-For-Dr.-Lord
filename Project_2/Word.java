public class Word 
{
    private String word;

    public Word(String word) 
    {
        this.word = word;
    }

    /* This is the get method for word as "word" is private. */
    public String getWord() 
    {
        return word;
    }

    /* Overriding the toString method here to use it in the PuzzleGUI class. */
    public String toString() 
    {
        return word;
    }
}
