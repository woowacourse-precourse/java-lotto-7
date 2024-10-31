package lotto.controller;

import lotto.config.LottoConfig;
import lotto.io.*;
import lotto.service.LottoService;
import lotto.validator.LottoInputValidator;

public class LottoController {

    private static LottoController controller;

    private final LottoService service;

    private LottoController(LottoConfig config) {
        this.service = config.lottoService();
    }

    public static LottoController getInstance(LottoConfig config) {

        if(controller == null)
            controller = new LottoController(config);

        return controller;
    }

    public void run() {

        int money = service.inputMoney();

    }
}
