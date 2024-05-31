public class WordNode 
{
    protected Word data;
    protected WordNode next;

    /* This one-argument constructor takes a "Word" as a parameter to create a new list node (WordNode). */
    public WordNode(Word w) 
    {
        data = w;
        next = null;
    }
}
