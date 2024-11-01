package lotto.controller;

import java.util.List;
import lotto.model.Lotto;

public class InputValidator {
    private static final int MINIMUM_AMOUNT = 1000;

    public void validatePurchaseAmount(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 음수이면 안됩니다.");
        }
        if (amount < MINIMUM_AMOUNT || amount % MINIMUM_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");
        }
        validateDuplication(numbers);
        for (int number : numbers) {
            validateNumbersRange(number);
        }
    }
    private void validateDuplication(List<Integer> numbers) {
        if(numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 존재 합니다.");
        }
    }

    public void validateBonusNumber(int bonus, Lotto winningNumbers) {
        validateNumbersRange(bonus);
        if (winningNumbers.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validateNumbersRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
