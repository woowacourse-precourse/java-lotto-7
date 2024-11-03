package lotto.service.generator;

import lotto.domain.Wallet;
import lotto.factory.WalletFactory;
import lotto.util.NumberValidator;

public class WalletGenerator {

    private final Integer money;

    public WalletGenerator(String money) {
        this.money = NumberValidator.change(money);
    }

    public Wallet getWallet() {
        return WalletFactory.create(money);
    }
}
