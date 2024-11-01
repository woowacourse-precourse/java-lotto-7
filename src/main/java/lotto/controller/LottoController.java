package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.view.OutputView;

public class LottoController {

    private final LottoInputManger inputManger;
    private final LottoMachine;
    private final OutputView;

    public LottoController(LottoInputManger inputManger) {
        this.inputManger = inputManger;
    }


}
