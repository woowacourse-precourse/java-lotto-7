package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        LottoDraw lottoDraw = new LottoDraw(purchaseAmount);
        OutputView.outputNumberOfPurchaseLotto(lottoDraw);

        Lotto lotto = new Lotto(InputView.inputLottoPrizeNumbers());
        int bonusNumber = InputView.inputLottoBonusNumber();
    }
}
