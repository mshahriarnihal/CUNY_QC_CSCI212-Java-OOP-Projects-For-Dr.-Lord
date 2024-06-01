/**
 * The UnsortedWordList class represents an unsorted list of words.
 * We need to use this to store solutions list. 
 * It extends the WordList class to inherit its functionality.
 */
public class UnsortedWordList extends WordList 
{
    /**
     * Constructs an UnsortedWordList object.
     * Calls the no-argument constructor of the superclass WordList.
     */
    public UnsortedWordList() 
    {
        super();    // Calling the no-argument constructor of the super class.
    }


    /* This method will add/connect new word (as node) at the end of the previous node as sorting is not required here. */
    /**
     * Adds a word to the unsorted list.
     * The word is added at the end of the list just by calling the "append" method from "WordList" class as sorting is not required here.
     * @param word The word which needs to be added.
     */
    public void add(Word word) 
    {
        append(word); // Utilizing the append method to add to the end of the list.        
    }
}
