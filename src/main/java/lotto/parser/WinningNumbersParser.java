package lotto.parser;

import lotto.domain.LottoConstants;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbersParser {
    private static final String WINNING_NUMBER_SEPARATOR = ",";

    public static Set<Integer> parse(String input) {
        validateInput(input);
        return processInput(input);
    }

    private static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해야 합니다.");
        }
    }

    private static Set<Integer> processInput(String input) {
        Set<Integer> winningNumbers = Arrays.stream(input.split(WINNING_NUMBER_SEPARATOR))
                .map(WinningNumbersParser::processWinningNumber)
                .collect(Collectors.toSet());

        validateWinningNumbers(winningNumbers);

        return winningNumbers;
    }

    private static int processWinningNumber(String input) {
        int winningNumber = inputToWinningNumbers(input);
        validateWinningNumber(winningNumber);
        return winningNumber;
    }

    private static int inputToWinningNumbers(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구분자와 숫자만 입력 가능합니다. (예: 1,6,14,43,31,5)");
        }
    }

    private static void validateWinningNumber(int winningNumber) {
        if (winningNumber < LottoConstants.MIN_LOTTO_NUMBER || winningNumber > LottoConstants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해야 합니다.");
        }
    }

    private static void validateWinningNumbers(Set<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoConstants.LOTTO_PICK_SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복을 제외하고 6자리 숫자를 입력해야 합니다.");
        }
    }
}
