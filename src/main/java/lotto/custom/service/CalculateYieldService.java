package lotto.custom.service;

import static lotto.custom.constants.NumberConstants.LOTTO_PRICE;

import java.util.List;
import lotto.custom.model.LottoPrize;
import lotto.custom.model.Lottos;

public class CalculateYieldService {

    public double run(List<Integer> result, Lottos myLottoTickets) {
        int index = 0;
        double sum = 0;

        for (LottoPrize prize : LottoPrize.values()) {
            sum += prize.getPrizeMoney() * result.get(index++);
        }

        int purchaseAmount = myLottoTickets.size() * LOTTO_PRICE;
        return sum / purchaseAmount * 100;
    }
}
