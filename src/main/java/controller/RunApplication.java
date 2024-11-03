package controller;

import domain.PlayerBuyLotto;
import view.Input;

public class RunApplication {

    public void run() {

        Input input = new Input();
        PlayerBuyLotto playerBuyLotto = new PlayerBuyLotto();

        while(true) {
            try {
                String purchaseAmount = input.inputPurchaseAmount();
                int LottoPurchased = playerBuyLotto.buyLotto(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
