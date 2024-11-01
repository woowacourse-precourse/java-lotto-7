package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ParseUtil;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        int purchaseAmount = ParseUtil.parseInt(inputView.inputPurchaseAmount());

        Console.close();
    }

}
