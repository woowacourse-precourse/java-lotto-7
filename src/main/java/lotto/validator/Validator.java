package lotto.validator;

import java.util.List;

public class Validator {
    public void validatePayment(int value) {
        validatePositive(value);

        if (value % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지도록 입력해주십시오.");
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        List<Integer> after = winningNumbers.stream().distinct().toList();

        if (winningNumbers.size() != after.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력하지 말아주십시오.");
        }

        for (Integer winningNumber : winningNumbers) {
            validateLottoNumber(winningNumber);
        }
    }

    public void validateLottoNumber(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("[ERROR] 1과 45 사이의 수를 입력해주십시오.");
        }
    }

    public void validatePositive(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주십시오.");
        }
    }
}
