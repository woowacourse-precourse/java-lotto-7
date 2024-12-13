package lotto.service;

import lotto.enums.LottoPrize;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateProfitRateTest {
    @Test
    void profitRate_계산_테스트() {
        Map<String, Integer> prizes = new LinkedHashMap<>();
        prizes.put("3개 일치", LottoPrize.THREE_WINNING_PRIZE.getPrize());
        prizes.put("4개 일치", LottoPrize.FOUR_WINNING_PRIZE.getPrize());
        prizes.put("5개 일치", LottoPrize.FIVE_WINNING_PRIZE.getPrize());
        prizes.put("5개 일치, 보너스 볼 일치", LottoPrize.FIVE_WINNING_WITH_BONUS_PRIZE.getPrize());
        prizes.put("6개 일치", LottoPrize.SIX_WINNING_PRIZE.getPrize());

        Map<String, Integer> winningLotto = new LinkedHashMap<>();
        winningLotto.put("3개 일치", 1);
        winningLotto.put("4개 일치", 0);
        winningLotto.put("5개 일치", 0);
        winningLotto.put("5개 일치, 보너스 볼 일치", 0);
        winningLotto.put("6개 일치", 0);

        CalculateProfitRate calculateProfitRate = new CalculateProfitRate(3000, winningLotto, prizes);

        assertEquals((5000.0 / 3000.0 * 100.0), calculateProfitRate.getProfitRate());
    }
}