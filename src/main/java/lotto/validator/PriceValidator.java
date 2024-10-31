package lotto.validator;

import lotto.view.InputView;

public class PriceValidator {

    private final InputView inputView;

    public PriceValidator(InputView inputView) {
        this.inputView = inputView;
    }

    public void validate(int price) {
        try {
            validatePositive(price);
            validateThousandUnit(price);
        } catch (IllegalArgumentException e) {
            inputView.getPriceInput();
        }
    }

    private void validatePositive(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수를 입력해 주세요.");
        }
    }

    private void validateThousandUnit(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수를 입력해 주세요.");
        }
    }

}
