package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoPrizeMap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateProfitRateTest {

    @Test
    void profitRate_계산_테스트() {
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(10, 11, 12, 4, 5, 6))
        ));
        int bonusNumber = 20;
        LottoPrizeMap lottoPrizeMap = new LottoPrizeMap();
        LottoWinning lottoWinning = new LottoWinning(List.of(1, 2, 3, 13, 14, 15), bonusNumber, lottos);

        CalculateProfitRate calculateProfitRate = new CalculateProfitRate(lottos.size() * 1000, lottoWinning.getWinningLotto(), lottoPrizeMap.getPrizes());

        assertEquals((5000.0 / 3000.0 * 100.0), calculateProfitRate.getProfitRate());
    }
}