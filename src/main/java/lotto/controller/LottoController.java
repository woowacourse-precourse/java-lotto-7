package lotto.controller;

import lotto.enums.Constants;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputView inputView;
    OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        int money = getMoney();
        int lottoAmount = buyLotto(money);
    }

    private int buyLotto(int money) {
        int lottoAmount = money / Constants.MONEY_UNIT.getValue();
        outputView.printLottoAmount(lottoAmount);
        return lottoAmount;
    }

    private int getMoney() {
        try {
            String inputMoney = inputView.promptMoney();
            LottoValidator.validateInputMoney(inputMoney);
            return Integer.parseInt(inputMoney);
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error.getMessage());
        }
        return getMoney();
    }
}
