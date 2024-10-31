package lotto.validator;

import lotto.view.InputView;

public class PriceValidator {

    public void validate(int price) {
        validatePositive(price);
        validateThousandUnit(price);
    }

    private void validatePositive(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수를 입력해 주세요.");
        }
    }

    private void validateThousandUnit(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수를 입력해 주세요.");
        }
    }

}
