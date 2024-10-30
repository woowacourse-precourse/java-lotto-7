package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputView implements AutoCloseable {

    public static String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return " ";
        }
    }

    @Override
    public void close() {
        Console.close();
    }
}
