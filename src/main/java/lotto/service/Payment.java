package lotto.service;

import lotto.domain.Wallet;
import lotto.util.ValidateNumber;

public class Payment {

    private static final Integer MIN_MONEY_UNIT = 1000;

    private final Wallet wallet;

    private Payment(String money) {
        Integer newMoney = ValidateNumber.change(money);
        this.wallet = Wallet.create(newMoney);
    }

    public static Payment create(String money) {
        return new Payment(money);
    }

    public Integer getLottoCount() {
        return wallet.getMoney() / MIN_MONEY_UNIT;
    }

    public Integer getWalletMoney() {
        return wallet.getMoney();
    }
}