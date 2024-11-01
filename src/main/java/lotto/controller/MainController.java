package lotto.controller;

import lotto.model.LottoBundle;
import lotto.model.LottoFactory;
import lotto.model.Wallet;
import static lotto.view.InputView.readPurchaseMoney;
import static lotto.model.LottoFactory.makeLottosByWalletMoney;

public class MainController {
    public static void run() {
        Wallet myWallet = makeWallet();
        LottoBundle lottoBundle = purchaseLottoBundle(myWallet);
    }

    public static Wallet makeWallet() {
        while (true) {
            try {
                String purchaseMoney = readPurchaseMoney();
                return new Wallet(purchaseMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static LottoBundle purchaseLottoBundle(Wallet wallet) {
        int amount = wallet.getAffordableLottoAmount();
        return LottoFactory.makeLottosByWalletMoney(amount);
    }
}
