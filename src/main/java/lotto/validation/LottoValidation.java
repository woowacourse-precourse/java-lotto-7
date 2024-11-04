package lotto.validation;

import java.util.ArrayList;
import java.util.List;

public class LottoValidation {
    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1000;

    public void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력 금액에 공백을 입력하면 안됩니다.");
        }
    }

    public int validateParsing(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] Integer로 변환이 불가능합니다.");
        }
    }

    public List<Integer> validateParsing(List<String> input) {
        try {
            List<Integer> winningNumber = new ArrayList<>();
            for (String number : input) {
                winningNumber.add(Integer.parseInt(number));
            }
            return winningNumber;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] Integer로 변환이 불가능합니다.");
        }
    }

    public void validatePositive(int input) {
        if (input <= ZERO) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해야 합니다.");
        }
    }

    public void validateDivisible(int input) {
        if (input % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어져야 합니다.");
        }
    }
}
