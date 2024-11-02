package lotto.service;

import lotto.factory.WalletFactory;
import lotto.domain.Wallet;

public class Payment {

    private static final Integer MIN_MONEY_UNIT = 1000;

    private final Wallet wallet;

    public Payment(String money) {
        this.wallet = WalletFactory.create(validateMoney(money));
    }

    private Integer validateMoney(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw  new IllegalArgumentException();
        }
    }

    public Integer getLottoCount() {
        return wallet.getMoney() / MIN_MONEY_UNIT;
    }

    public Integer getWalletMoney() {
        return wallet.getMoney();
    }
}