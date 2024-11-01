package lotto.controller;

import lotto.model.Wallet;
import static lotto.view.InputView.readPurchaseMoney;

public class MainController {
    public static void run() {
        Wallet myWallet = makeWallet();
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
