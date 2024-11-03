package lotto.factory;

import lotto.domain.Wallet;

public class WalletFactory {

    public static Wallet create(Integer money) {
        return new Wallet(money);
    }
}
