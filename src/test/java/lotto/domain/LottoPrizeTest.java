package lotto.domain;

import lotto.config.LottoSettings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoPrizeTest {

    @DisplayName("상금 n개 일치 테스트")
    @Test
    void getPrizeTest() {
        long prize;

        prize = LottoPrize.getPrize(3);
        assertEquals(LottoSettings.PRIZE_3.getValue(), prize);

        prize = LottoPrize.getPrize(4);
        assertEquals(LottoSettings.PRIZE_4.getValue(), prize);

        prize = LottoPrize.getPrize(5);
        assertEquals(LottoSettings.PRIZE_5.getValue(), prize);

        prize = LottoPrize.getPrize(55);
        assertEquals(LottoSettings.PRIZE_5_BONUS.getValue(), prize);

        prize = LottoPrize.getPrize(5, 1);
        assertEquals(LottoSettings.PRIZE_5_BONUS.getValue(), prize);

        prize = LottoPrize.getPrize(6);
        assertEquals(LottoSettings.PRIZE_6.getValue(), prize);
    }
}
