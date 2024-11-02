package lotto.validation;

import java.util.List;

public class LottoValidation {
    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
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

    public void validateSize(List<String> input){
        if (input.size()!=LOTTO_NUMBER_COUNT){
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력해야 합니다.");
        }
    }
}
