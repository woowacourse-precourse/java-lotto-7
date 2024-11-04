package lotto.io;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * <code>IOManager</code> is an interface that provides input/output operations.
 * It is used to <b>separate</b> the input/output operations from the business logic.
 */
public interface IOManager extends AutoCloseable {
    /**
     * Get a message from the user.
     *
     * @return a message from the user
     * @throws NoSuchElementException if no line was found
     * @throws IllegalStateException  if this scanner is closed
     */
    String getUserMessage();

    /**
     * Get a number from the user.
     *
     * @return a number from the user
     * @throws UnsupportedOperationException if the method is not implemented
     * @throws NoSuchElementException        if no line was found
     * @throws IllegalStateException         if this scanner is closed
     * @throws NumberFormatException         if the next token does not match the Integer regular expression, or is out
     *                                       of range
     */
    default Integer getUserNumber() {
        throw new UnsupportedOperationException("getUserNumber method is not implemented");
    }

    /**
     * Get numbers from the user.
     *
     * @return numbers from the user
     * @throws UnsupportedOperationException if the method is not implemented
     * @throws NoSuchElementException        if no line was found
     * @throws IllegalStateException         if this scanner is closed
     * @throws NumberFormatException         if the next token does not match the Integer regular expression, or is out
     *                                       of range
     */
    default List<Integer> getUserNumbers() {
        throw new UnsupportedOperationException("getUserNumbers method is not implemented");
    }

    /**
     * Print a message.
     *
     * @param message a message to print
     */
    void printMessage(String message);
}
