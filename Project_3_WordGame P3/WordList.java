/**
 * The WordList class represents a list of words.
 * It provides methods to manipulate and access the list. Actually it gives limited access by using "protected."
 */
public abstract class WordList 
{
    protected WordNode head; 
    protected WordNode last;        // To keep track of the last node.
    protected int length;

    /**
     * Constructs a WordList object.
     * Initializes the head node with null data and sets last to point to the head initially.
     */
    public WordList() 
    {
        head = new WordNode(null);  // Initializes the head node with null data
        last = head;                // Last points to the head initially.
        length = 0;
    }

    /**
     * Appends a word to the end of the list.
     * @param word The word that needs to be appended/added.
     */
    public void append(Word word)   // This void method appends a word to the end of the list.
    {
        WordNode newNode = new WordNode(word);
        last.next = newNode;        // Connects the last node to the new node.
        last = newNode;             // Updates last to point to the new last node.
        length++;
    }

    /**
     * Clears the contents of the word list.
     */
    public void clear()             /* This method clears the contents of the word list. */
    {
        head.next = null;
        length = 0;                 // Resets the length of the list to 0
    }

    /**
     * Adds a word to the word list.
     * This method is abstract and must be implemented by subclasses.
     * @param word The word to be added.
     */
    public abstract void add(Word word);

    /**
     * Retrieves the length of the word list as int variable "length" is not public.
     * @return
     */
    public int getLength() 
    {
        return length;
    }
}
