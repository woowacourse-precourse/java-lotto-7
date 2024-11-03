package lotto.service.generator;

import lotto.domain.Wallet;
import lotto.factory.WalletFactory;
import lotto.util.ValidateNumber;

public class WalletGenerator {

    private final Integer money;

    public WalletGenerator(String money) {
        this.money = ValidateNumber.change(money);
    }

    public Wallet getWallet() {
        return WalletFactory.create(money);
    }
}
