package lotto.factory;

import lotto.service.generator.WalletGenerator;

public class WalletGeneratorFactory {

    public static WalletGenerator create(String money) {
        return new WalletGenerator(money);
    }
}
