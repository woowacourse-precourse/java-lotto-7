package lotto.io.reader;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import lotto.exception.io.IllegalNumberFormatException;

public class MissionUtilsReader implements Reader {

    @Override
    public List<Integer> readLineAsNumbers(String spliter) {
        return withHandleException(() -> {
            String input = Console.readLine();
            return Arrays.stream(input.split(spliter))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        });
    }

    @Override
    public int readLineAsNumber() {
        return withHandleException(() -> {
            String input = Console.readLine();
            return Integer.parseInt(input);
        });
    }

    private static <T> T withHandleException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalNumberFormatException();
        }
    }
}
