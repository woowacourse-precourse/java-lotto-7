package lotto.controller;

import lotto.domain.LottoMoney;
import lotto.io.InputReader;
import lotto.io.view.View;

public class LottoController {
    private final InputReader reader;
    private final View view;

    public LottoController(InputReader reader, View view) {
        this.reader = reader;
        this.view = view;
    }

    public void run() {
        view.getInputView().showMoneyInputExplanation();
        int userInputMoney = Integer.parseInt(reader.read());
        LottoMoney money = LottoMoney.of(userInputMoney);
    }
}
