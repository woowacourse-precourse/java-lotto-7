package lotto.service.generator;

import lotto.domain.Wallet;
import lotto.factory.WalletFactory;
import lotto.util.NumberValidator;

public class WalletGenerator {

    private final Integer money;

    private WalletGenerator(String money) {
        this.money = NumberValidator.change(money);
    }

    public static WalletGenerator create(String money) {
        return new WalletGenerator(money);
    }

    public Wallet getWallet() {
        return WalletFactory.create(money);
    }
}
