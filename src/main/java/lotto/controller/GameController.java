package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.util.InputValidator;
import lotto.view.UserInputView;
import lotto.view.UserOutputView;

import java.util.List;

public class GameController {

    public void run() {
        int purchaseAmount = getPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchaseLottos(purchaseAmount);

        UserOutputView.outputLottos(lottos);
    }

    private int getPurchaseAmount() {
        String inputPurchaseAmount = UserInputView.inputPurchaseAmount();

        try {
            InputValidator.validatePurchaseAmount(inputPurchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }

        return Integer.parseInt(inputPurchaseAmount);
    }
}
