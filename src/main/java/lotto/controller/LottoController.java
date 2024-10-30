package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.view.InputView;

public class LottoController {
    public static void statrLotto() {
        LottoMachine lottoMachine = inputPrice();

    }

    private static LottoMachine inputPrice() {
        try {
            int price = InputView.inputPrice();
            return new LottoMachine(price);
        } catch (IllegalArgumentException e) {
            InputView.errorPrint(e.getMessage());
            return inputPrice();
        }
    }


}
