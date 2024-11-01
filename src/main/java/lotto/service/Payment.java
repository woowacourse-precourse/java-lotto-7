package lotto.service;

import lotto.domain.Wallet;

public class Payment {

    private static final Integer MIN_MONEY_UNIT = 1000;

    private final Wallet wallet;

    public Payment(Wallet wallet) {
        this.wallet = wallet;
    }

    public Integer getLottoCount() {
        return wallet.getMoney() / MIN_MONEY_UNIT;
    }

    public Integer getWalletMoney() {
        return wallet.getMoney();
    }
}