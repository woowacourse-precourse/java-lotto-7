package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {
    public int readInteger() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public List<Integer> readIntegerList() {
        String input = Console.readLine();
        return parseDelimiter(input);
    }

    private List<Integer> parseDelimiter(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
