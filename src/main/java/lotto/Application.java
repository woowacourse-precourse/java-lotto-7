package lotto;

import lotto.InputView;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = InputView.readPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}