package lotto.controller;

import static lotto.utils.Parser.parseStringToInteger;
import static lotto.view.InputView.readPurchaseMoney;

import lotto.model.LottoBundle;
import lotto.model.LottoFactory;
import lotto.model.Wallet;

public class LottoStore {
    public static Wallet makeWallet() {
        while (true) {
            try {
                String purchaseMoneyInput = readPurchaseMoney();
                Integer parsedPurchaseMoney = parseStringToInteger(purchaseMoneyInput);
                return new Wallet(parsedPurchaseMoney);
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
