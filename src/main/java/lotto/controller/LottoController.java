package lotto.controller;

import lotto.common.Constants;
import lotto.service.LottoService;

public class LottoController {

    private int lottoCount;
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() {

    }

}
