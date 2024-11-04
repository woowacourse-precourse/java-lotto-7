package lotto.io;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implementation of <code>IOManager</code> that can be used for testing.
 * <p>
 * <ul>
 *   <li>Set <code>input</code> to the desired input value before calling the methods.</li>
 *   <li>Get <code>outputBuilder</code> to the desired output value after calling the methods.</li>
 * </ul>
 * <p>
 * The method call history is stored in the corresponding field.
 * <ul>
 *   <li>Method call count is stored in <code>methodCallCount</code>.</li>
 *   <li>Last argument passed to method is stored in <code>methodLastCalledWith</code>.</li>
 * </ul>
 *
 * @see IOManager
 */
public class MockedIOManager implements IOManager {
    public String input;
    public StringBuilder outputBuilder = new StringBuilder();

    public int getUserMessageCallCount = 0;
    public int getUserNumberCallCount = 0;
    public int getUserNumbersCallCount = 0;
    public int printMessageCallCount = 0;
    public String printMessageLastCalledWith = null;

    @Override
    public String getUserMessage() {
        getUserMessageCallCount++;
        return input;
    }

    @Override
    public Integer getUserNumber() {
        getUserNumberCallCount++;
        return Integer.parseInt(input);
    }

    @Override
    public List<Integer> getUserNumbers() {
        getUserNumbersCallCount++;
        return Stream.of(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    @Override
    public void printMessage(String message) {
        printMessageCallCount++;
        printMessageLastCalledWith = message;
        outputBuilder.append(message).append("\n");
    }

    @Override
    public void close() {
    }
}
