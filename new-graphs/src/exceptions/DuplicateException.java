package exceptions;

public class DuplicateException extends RuntimeException
{
    public DuplicateException()
    {
        super("Duplicates are not allowed!");
    }

    public DuplicateException(String message)
    {
        super(message);
    }
}
