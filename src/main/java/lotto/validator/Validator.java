package lotto.validator;

import java.util.List;

public class Validator {
    public void validatePayment(int value) {
        isPositive(value);

        if (value % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지도록 입력해주십시오.");
        }
    }

    public void validateWinningNumbers(List<Integer> numbers) {
        List<Integer> after = numbers.stream().distinct().toList();

        if (numbers.size() != after.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력하지 말아주십시오.");
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 입력해주십시오.");
        }

        numbers.forEach(this::validateLottoNumber);
    }

    public void validateLottoNumber(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("[ERROR] 1과 45 사이의 수를 입력해주십시오.");
        }
    }

    private void isPositive(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주십시오.");
        }
    }
}
