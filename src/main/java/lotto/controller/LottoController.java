package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();
    public void run() {
        Integer lottoCount = getLottoCount();
    }

    private Integer getLottoCount() {
        outputView.printMessage("구입금액을 입력해 주세요.");
        return inputView.inputPrice();
    }
}
