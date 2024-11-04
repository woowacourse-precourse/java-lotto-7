package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumber {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String ERROR_INVALID_FORMAT = "당첨 번호는 쉼표(,)로 구분된 6개의 숫자여야 합니다.";
    private static final String ERROR_BONUS_DUPLICATE = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final int WINNING_NUMBER_SIZE = 6;

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumber(String input, String bonusInput) {
        this.winningLotto = new Lotto(parseNumbers(input));
        this.bonusNumber = validateAndParseBonusNumber(bonusInput);
    }

    private List<Integer> parseNumbers(String input) {
        try {
            List<String> numbers = Arrays.asList(input.split(","));
            if (numbers.size() != WINNING_NUMBER_SIZE) {
                throw new IllegalArgumentException(ERROR_PREFIX + ERROR_INVALID_FORMAT);
            }
            return numbers.stream()
                    .map(String::trim)
                    .map(this::parseNumber)
                    .toList();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_INVALID_FORMAT);
        }
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_INVALID_FORMAT);
        }
    }

    private int validateAndParseBonusNumber(String input) {
        int number = parseNumber(input);
        if (winningLotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_BONUS_DUPLICATE);
        }
        return number;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}