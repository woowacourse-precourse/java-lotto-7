package lotto.controller;

import lotto.config.LottoConfig;
import lotto.io.*;
import lotto.validator.LottoInputValidator;

public class LottoController {

    private final Input input;
    private final Output output;

    private LottoController(LottoConfig config) {
        this.input = config.input();
        this.output = config.output();
    }

    public static LottoController getInstance(LottoConfig config) {
        return new LottoController(config);
    }

    public void run() {

        int money = LottoInputValidator.checkInputMoney(input.inputMoney());
        if(money == -1)
            return;


    }
}
