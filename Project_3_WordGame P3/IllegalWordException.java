/**
 * The IllegalWordException class represents an exception thrown when an illegal word is encountered.
 * It extends the IllegalArgumentException class to indicate that the word is illegal.
 */
public class IllegalWordException extends IllegalArgumentException   // Creating an exception called IllegalWordException (by extending IlegalArgumentException).
{
    /**
     * Constructs an IllegalWordException with the specified detail message about the issue.
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public IllegalWordException(String message) 
    {
        super(message);   // Calls the superclass constructor with the provided message.
    }
}
