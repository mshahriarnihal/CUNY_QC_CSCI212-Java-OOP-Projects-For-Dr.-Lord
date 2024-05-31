/* Creating this abstract linked list to use further in Unsorted and Sorted linked lists to store words as nodes. */

public abstract class WordList 
{
    protected WordNode head;
    protected int length;

    public WordList()  // No argument constructor for the linked list (WordList) that creates an empty list.
    {
        head = new WordNode(null);
        length = 0;
    }


    public abstract void add(Word word);  /* This method will be used to add new words to the sorted and unsorted linked lists (SortedWordList, UnsortedWordList). */


    public int getLength() 
    {
        return length;
    }
}
