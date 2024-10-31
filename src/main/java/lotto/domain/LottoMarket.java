package lotto.domain;

import lotto.Lotto;

public class LottoMarket {

    private static final int LOTTO_PRICE = 1000;

    public Lotto buyLotto(int money) {

        validateMoney(money);
    }

    private void validateMoney(int money) {
        validatePositive(money);
        validateDivisibleByThousand(money);
    }

    private void validatePositive(int money) {
        if (money < 1) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivisibleByThousand(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
