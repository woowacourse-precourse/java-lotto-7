package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private static final String EMPTY_INPUT_ERROR = "[ERROR] 당첨 번호가 입력되지 않았습니다.";
    private static final String INVALID_COUNT_ERROR = "[ERROR] 당첨 번호는 6개여야 합니다.";
    private static final String DUPLICATE_WINNING_NUMBERS_ERROR = "[ERROR] 당첨 번호에 중복이 있을 수 없습니다.";
    private static final String INVALID_WINNING_NUMBER_ERROR = "[ERROR] 당첨 번호는 1과 45 사이의 숫자여야 합니다.";
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String SEPARATOR = ",";

    private List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbersInput) {
        this.winningNumbers = parseWinningNumbers(winningNumbersInput);
    }

    private List<Integer> parseWinningNumbers(String winningNumbersInput) {
        return Arrays.stream(winningNumbersInput.split(SEPARATOR))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> get() {
        return winningNumbers;
    }
}
