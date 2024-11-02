package lotto.custom.service;

import static lotto.custom.constants.NumberConstants.LOTTO_PRICE;

import java.util.List;
import lotto.custom.model.LottoYieldCalculator;
import lotto.custom.model.Lottos;

public class CalculateYieldService {
    private final LottoYieldCalculator lottoYieldCalculator;

    public CalculateYieldService() {
        this.lottoYieldCalculator = new LottoYieldCalculator();
    }

    public double run(List<Integer> result, Lottos myLottoTickets) {
        int purchaseAmount = myLottoTickets.size() * LOTTO_PRICE;
        return lottoYieldCalculator.run(result, purchaseAmount);
    }
}