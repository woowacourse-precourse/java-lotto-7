package lotto.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumberValidator {
    private final static String INVALID_WINNING_NUMBER_INPUT = "[ERROR] 올바른 당첨 번호를 입력해 주세요";
    private final static String INVALID_WINNING_NUMBER_COUNT_INPUT = "[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.";
    private final static String INVALID_WINNING_NUMBER_RANGE_INPUT = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다";
    private final static String INVALID_BONUS_NUMBER_INPUT = "[ERROR] 올바른 보너스 번호를 입력해 주세요";
    private final static String INVALID_BONUS_NUMBER_RANGE_INPUT = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다";
    private final static String INVALID_BONUS_NUMBER_DUPLICATE_INPUT = "[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.";

    public static List<Integer> parseValidatedWinningNumber(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_INPUT);
        }
        Set<Integer> numbers = Arrays.stream(input.replaceAll("\\s", "").split(","))
                .filter(s -> !s.isBlank())
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_COUNT_INPUT);
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(INVALID_WINNING_NUMBER_RANGE_INPUT);
            }
        }
        return new ArrayList<>(numbers);
    }

    public static int parseValidatedBonusNumber(String input, List<Integer> winningNumber) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_INPUT);
        }
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_INPUT);
        }
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE_INPUT);
        }
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_DUPLICATE_INPUT);
        }
        return bonusNumber;
    }
}
