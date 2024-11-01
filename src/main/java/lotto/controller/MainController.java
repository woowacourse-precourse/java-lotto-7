package lotto.controller;

import lotto.model.LottoBundle;
import lotto.model.Wallet;
import static lotto.view.InputView.readPurchaseMoney;
import static lotto.model.LottoFactory.makeLottosByWalletMoney;

public class MainController {
    public static void run() {
        Wallet myWallet = makeWallet();
        LottoBundle lottoBundle = makeLottosByWalletMoney(myWallet);
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
}
