package lotto.io;

import java.util.List;
import java.util.stream.Stream;

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
