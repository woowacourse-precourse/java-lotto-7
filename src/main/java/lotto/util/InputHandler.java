package lotto.util;

import static lotto.constant.ErrorCode.INVALID_INPUT_FORMAT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.OutputView;

public class InputHandler {

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            OutputView.printError(INVALID_INPUT_FORMAT.getMessage());
            return -1;
        }
    }

    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    public static List<Integer> stringListToIntList(List<String> stringList) {
        return stringList.stream()
            .map(InputHandler::parseInt)
            .collect(Collectors.toList());
    }
}
