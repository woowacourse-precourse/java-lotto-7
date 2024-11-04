package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        InputView inputView = new InputView(inputValidator);

        OutputView outputView = new OutputView();
        LottoPurchase lottoPurchase = new LottoPurchase();

        LottoGame lottoGame = new LottoGame(inputView, outputView, lottoPurchase);
        lottoGame.start();
    }
}
