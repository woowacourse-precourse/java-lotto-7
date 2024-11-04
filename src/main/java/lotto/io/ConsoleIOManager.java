package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleIOManager implements IOManager {
    @Override
    public String getUserMessage() {
        return Console.readLine();
    }

    @Override
    public Integer getUserNumber() {
        try {
            return Integer.parseInt(getUserMessage());
        } catch (NumberFormatException e) {
            throw IOException.CANNOT_PARSE_TO_INTEGER.getException();
        }
    }

    @Override
    public List<Integer> getUserNumbers() {
        try {
            String[] numbers = getUserMessage().split(",");
            return Arrays.stream(numbers).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw IOException.CANNOT_PARSE_TO_INTEGER.getException();
        }
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void close() {
        Console.close();
    }
}
