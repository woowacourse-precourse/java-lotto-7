package lotto.domain;

import static lotto.global.LottoScore.NO_PRIZE;
import static lotto.global.LottoScore.SECOND;
import static lotto.global.LottoScore.THIRD;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculate;
import lotto.global.LottoScore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoCalculateTest {

    private LottoCalculate lottoCalculate;

    @BeforeEach
    void setUp() {
        lottoCalculate = new LottoCalculate();
    }

    @Test
    void 로또_번호_5개_맞히면_3등() {
        lottoCalculate.calculateLottoNumbers(List.of(1, 2, 3, 4, 5, 6), List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7))),
                8);
        LottoScore lottoScore = lottoCalculate.getLottoScores().get(0);

        Assertions.assertEquals(lottoScore, THIRD);
    }

    @Test
    void 로또_번호_5개와_보너스_번호_맞히면_2등() {
        lottoCalculate.calculateLottoNumbers(List.of(1, 2, 3, 4, 5, 8), List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7))),
                7);
        LottoScore lottoScore = lottoCalculate.getLottoScores().get(0);

        Assertions.assertEquals(lottoScore, SECOND);
    }

    @Test
    void 로또_번호_3개_미만_맞힐시_상_없음() {
        lottoCalculate.calculateLottoNumbers(List.of(1, 2, 3, 4, 5, 6), List.of(new Lotto(List.of(1, 2, 7, 8, 9, 10))),
                11);
        LottoScore lottoScore = lottoCalculate.getLottoScores().get(0);

        Assertions.assertEquals(lottoScore, NO_PRIZE);
    }
}