public class WordNode 
{
    /**
     * The WordNode class represents a node in a linked list (WordList) of words.
     * It encapsulates a word and a reference to the next node.
     */
    protected Word data;
    protected WordNode next;    // Reference to the next node.


    /**
     * Constructs a WordNode object with the specified word.
     * @param w The word that needs to be encapsulated in the node.
     */
    public WordNode(Word w) /* This one-argument constructor takes a "Word" as a parameter to create a new list node (WordNode). */
    {
        data = w;
        next = null;
    }
}
