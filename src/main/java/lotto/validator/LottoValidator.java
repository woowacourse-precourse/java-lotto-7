package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void validatePrice(String input) {
        try {
            int price = Integer.parseInt(input);
            if (price % 1000 != 0) {
                throw new IllegalArgumentException(ERROR_MESSAGE + " 구입 금액은 1000원 단위이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입 금액은 숫자이어야 합니다.");
        }
    }

    public static void validateWinningNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 당첨 번호는 중복될 수 없습니다.");
        }

        for (Integer number : numbers) {
            validateNumberType(number);
            validateNumberRange(number);
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateNumberRange(bonusNumber);
        validateDuplicateNumbers(bonusNumber, winningNumbers);
    }

    private static void validateDuplicateNumbers(int bonusNumber, List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateNumberType(Object numberObj) {
        if (!(numberObj instanceof Integer)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 번호는 숫자여야 합니다.");
        }
    }
}
