package lotto.domain;

import static lotto.global.LottoScore.FIFTH;
import static lotto.global.LottoScore.FIRST;
import static lotto.global.LottoScore.SECOND;
import static lotto.global.LottoScore.THIRD;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoResult;
import lotto.global.LottoScore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @Test
    void 로또_갯수에_따른_각_등수_갯수_반환() {
        Map<LottoScore, Integer> lottoScore = lottoResult.integrateLottoScore(
                List.of(FIRST, SECOND, SECOND, THIRD));

        assertEquals(lottoScore.get(FIRST), 1);
        assertEquals(lottoScore.get(SECOND), 2);
        assertEquals(lottoScore.get(THIRD), 1);
    }

    @Test
    void 로또_수익률_계산() {
        int money = 10000;

        lottoResult.integrateLottoScore(List.of(FIFTH));
        double lottoProfit = lottoResult.calculateLottoProfit(money);

        assertEquals(lottoProfit, 50.0);
    }
}