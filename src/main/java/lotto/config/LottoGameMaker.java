package lotto.config;

import lotto.controller.LottoGame;
import lotto.service.LottoPurchase;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameMaker {
    public LottoGame makeLottoGame() {
        InputValidator inputValidator = new InputValidator();
        InputView inputView = new InputView(inputValidator);
        OutputView outputView = new OutputView();
        LottoPurchase lottoPurchase = new LottoPurchase();

        return new LottoGame(inputView, outputView, lottoPurchase);
    }

}
