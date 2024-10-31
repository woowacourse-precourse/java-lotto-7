package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        Lotto lotto = new Lotto(InputView.inputLottoPrizeNumbers());
    }
}
