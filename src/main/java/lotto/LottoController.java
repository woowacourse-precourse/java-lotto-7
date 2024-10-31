package lotto;

import validator.Validator;
import view.InputView;

public class LottoController {
    public final int LOTTO_COST = 1000;
    long purchaseMoney, winningMoney = 0;
    Lotto[] lottos;


    public void startProgram() {
        purchaseMoney = InputView.inputPurchaseMoney();
        Validator.validatePurchasing(purchaseMoney, LOTTO_COST);
    }
}
