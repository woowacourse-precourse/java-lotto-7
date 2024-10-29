package lotto.controller;

import lotto.model.LottoModel;
import lotto.view.LottoView;

import java.util.Arrays;

public class LottoController {
    private final LottoModel lottoModel = new LottoModel();
    private final LottoView lottoView = new LottoView();


    public void start() {
        lottoView.input.price();
        lottoView.output.lottoCount(2);
        for (int i = 0; i < 2; i++) {
            lottoView.output.lottoNumber(Arrays.asList(1, 2, 3));
        }
        lottoView.input.winningNumber();
        lottoView.input.bonusNumber();
        lottoView.output.winningResult();
    }
}
