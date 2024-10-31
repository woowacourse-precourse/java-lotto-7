package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.Rank;
import lotto.view.LottoView;

public class LottoController {
    private final LottoMachine lottoMachine;
    private final LottoView lottoView;

    public LottoController(LottoMachine lottoMachine, LottoView lottoView) {
        this.lottoMachine = lottoMachine;
        this.lottoView = lottoView;
    }

    private double calculateProfitRate(List<Rank> results, int purchaseAmount) {
        int totalPrize = results.stream().mapToInt(Rank::getPrize).sum();
        return (double) totalPrize / purchaseAmount * 100;
    }
}
