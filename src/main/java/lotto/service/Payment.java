package lotto.service;

import lotto.domain.Wallet;
import lotto.factory.WalletFactory;
import lotto.util.ValidateNumber;

public class Payment {

    private static final Integer MIN_MONEY_UNIT = 1000;

    private final Wallet wallet;

    public Payment(String money) {
        Integer newMoney = ValidateNumber.change(money);
        this.wallet = WalletFactory.create(newMoney);
    }

    public Integer getLottoCount() {
        return wallet.getMoney() / MIN_MONEY_UNIT;
    }

    public Integer getWalletMoney() {
        return wallet.getMoney();
    }
}