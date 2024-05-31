public class UnsortedWordList extends WordList 
{
    public UnsortedWordList() 
    {
        super();    // Calling the no-argument constructor of the super class.
    }


    /* This method will add/connect new word (as node) at the end of the previous node as sorting is not required here. */ 
    public void add(Word word) 
    {
        WordNode newNode = new WordNode(word); // Creates a new node and set the "data" of the new node according to "word" parameter.
        WordNode current = head;

        while (current.next != null)  // This while loop continues until it reaches the last node. 
        {
            current = current.next;
        }

        current.next = newNode;    /* Sets the last node to the newly created node (newNode). */
        length++;    // Updates the length (total number of words).
    }
}
