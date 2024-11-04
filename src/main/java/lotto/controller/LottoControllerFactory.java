package lotto.controller;

import lotto.service.LottoService;

public class LottoControllerFactory {

    public static LottoController getLottoController() {
        return new LottoController(new LottoService());
    }
}
