package lotto.Factory;

import lotto.domain.Wallet;

public class WalletFactory {

    public static Wallet createWallet(Integer money) {
        return new Wallet(money);
    }
}
