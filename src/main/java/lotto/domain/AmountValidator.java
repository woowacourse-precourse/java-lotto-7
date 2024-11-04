package lotto.domain;

import java.util.Objects;

public class AmountValidator {

    public Integer validate(String inputPurchaseAmount) {
        isBlank(inputPurchaseAmount);

        return convert(inputPurchaseAmount);
    }

    private void isBlank(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 비어있습니다.");
        }
    }

    private void isDivisibleBy1000(Integer amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로만 입력이 가능합니다.");
        }
    }

    private void isZeroOrNegative(Integer amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0 또는 음수를 입력할 수 없습니다.");
        }
    }

    private Integer convert(String input) {
        try {
            Integer amount = Integer.parseInt(input);
            isDivisibleBy1000(amount);
            isZeroOrNegative(amount);

            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수로만 입력이 가능합니다.");
        }
    }
}