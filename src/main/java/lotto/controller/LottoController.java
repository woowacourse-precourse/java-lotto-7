package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.LottoBuyer;
import lotto.model.LottoMachine;
import lotto.model.Money;
import lotto.view.InputView;

public class LottoController {
    private final LottoBuyer lottoBuyer;

    public LottoController() {
        LottoMachine lottoMachine = new LottoMachine();
        this.lottoBuyer = new LottoBuyer(lottoMachine);
    }

    private Money inputPurchaseAmount() {
        while (true) {
            try {
                return InputView.inputPurchaseAmount();
            } catch (IllegalArgumentException e) {
                InputView.errorPrint(e.getMessage());
            }
        }
    }

    private String inputWinningNumber() {
        while (true) {
            try {
                return InputView.inputWinningNumber();
            } catch (IllegalArgumentException e) {
                InputView.errorPrint(e.getMessage());
            }
        }
    }

    private BonusNumber inputBonusNumber() {
        while (true) {
            try {
                return InputView.inputBonusNumber();
            } catch (IllegalArgumentException e) {
                InputView.errorPrint(e.getMessage());
            }
        }
    }

}
