package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.exception.ExceptionMessage;

public class InputView {
    private static final String COMMA = ",";

    public int inputNumber() {
        while (true) {
            String input = readLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(ExceptionMessage.INVALID_NUMBER_FORMAT.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumbers() {
        while (true) {
            String[] winningNumbers = readLine().split(COMMA);
            try {
                return Stream.of(winningNumbers)
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                System.out.println(ExceptionMessage.INVALID_NUMBER_FORMAT.getMessage());
            }
        }
    }
}
