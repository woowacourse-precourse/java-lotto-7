package lotto.controller;

import lotto.service.LottoService;

public class LottoController {

    private int lottoCount;

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }




}
