package lotto.view.converter.validator;

import lotto.constant.LottoConstant;

public class LottoMoneyValidator {

    public void validate(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
        }
    }

    public void validate(int money) {
        validatePositive(money);
        validateUnitOfThousand(money);
    }

    private void validatePositive(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0원 보다 커야 합니다.");
        }
    }

    private void validateUnitOfThousand(int money) {
        if (money % LottoConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
    }

}
