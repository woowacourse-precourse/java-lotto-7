package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumberInputView {
    public static final String FORMAT_ERROR_MESSAGE = "숫자만 입력해주세요. 공백 또한 안됩니다.";

    public static List<Integer> getWinningNumber() {
        try {
            String numbers = Console.readLine();
            return Stream.of(numbers.split(","))
                    .filter(i -> !i.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE);
        }

    }
}
