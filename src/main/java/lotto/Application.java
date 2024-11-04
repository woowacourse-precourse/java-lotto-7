package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoPurchase lottoPurchase = new LottoPurchase();

        LottoGame lottoGame = new LottoGame(inputView, outputView, lottoPurchase);
        lottoGame.start();
    }
}
