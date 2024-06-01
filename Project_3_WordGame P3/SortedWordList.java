/**
 * The SortedWordList class represents a sorted list of words.
 * This sorting is essential to store words correctly guessed by the user and display them alphabetically in the GUI.
 * It extends the WordList class to inherit its ability.
 */
public class SortedWordList extends WordList 
{
    /**
     * Constructs a SortedWordList object.
     * Calls the no-argument constructor of the superclass WordList.
     */
    public SortedWordList() 
    {
        super();       // Calling the no-argument constructor of the super class.
    }


    /* This method will add/connect new word (as node) while maintaing the alphabetical order (sorting). */
    /**
     * Adds a word to the sorted list while maintaining alphabetical order.
     * @param word The word which needs to be added.
     */
    public void add(Word word) 
    {
        WordNode newNode = new WordNode(word);  /* Creates a new node and set the "data" of the new node according to "word" parameter. */
        WordNode current = head;

        while (current.next != null && current.next.data.getWord().toUpperCase().compareTo(word.getWord().toUpperCase()) < 0)  /* Using compareTo() method to ensure alphabetical order. */
        {
            current = current.next;
        }

        newNode.next = current.next;  /* Replacing newNode's pointer (newNode.next) with current.next as newNode is being placed between current and current.next */
        current.next = newNode;       /* Now the newNode comes after the node "current" as newNode is placed between current and current.next. */
        length++;
    }
}
