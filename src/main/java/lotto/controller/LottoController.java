package lotto.controller;

import lotto.view.LottoOutput;
import lotto.entity.Lottos;

public class LottoController {

    private final Lottos lottos;
    private final LottoOutput lottoOutput;

    public LottoController(Lottos lottos, LottoOutput output) {
        this.lottos = lottos;
        this.lottoOutput = output;
    }
}
