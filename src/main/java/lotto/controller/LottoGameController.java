package lotto.controller;

import lotto.model.LottoPurchase;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public final class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        while (true) {
            try {
                play();
                break;
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

    private void play() {
        LottoPurchase lottoPurchase = buyLotto();

    }

    private LottoPurchase buyLotto() {
        LottoPurchase lottoPurchase = new LottoPurchase(readMoney());

        return lottoPurchase;
    }

    private int readMoney() {
        String moneyInput = inputView.getMoneyInput();

        Validator.validateMoneyInput(moneyInput);

        return Integer.parseInt(moneyInput);
    }
}
