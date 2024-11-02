package lotto.domain;

public class LottoShop {
    private final int LOTTO_UNIT_PRICE = 1_000;
    private final int NO_REMAINDER = 0;

    public void buyLotto(int money) {
        validateMinimumPurchaseAmount(money);
        validateThousandUnitAmount(money);
    }

    private void validateThousandUnitAmount(int money) {
        if (money % LOTTO_UNIT_PRICE != NO_REMAINDER) {
            throw new IllegalArgumentException("로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private void validateMinimumPurchaseAmount(int money) {
        if (money < LOTTO_UNIT_PRICE) {
            throw new IllegalArgumentException("최소 구입 금액은 1,000원 입니다.");
        }
    }
}
