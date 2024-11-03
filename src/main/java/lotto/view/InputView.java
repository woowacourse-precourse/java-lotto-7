package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.Spliter.splitStringByDelimiter;

import java.util.List;

public class InputView {
    private InputView() {
    }

    public static int getUserInput() {
        String input = readLine();
        validateNumericInput(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> getUserInputByList() {
        String winningNumbers = readLine();
        List<String> splitString = splitStringByDelimiter(winningNumbers);
        for (String str : splitString) {
            validateNumericInput(str);
        }
        return splitString.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("금액은 숫자여야 합니다.");
        }
    }
}
