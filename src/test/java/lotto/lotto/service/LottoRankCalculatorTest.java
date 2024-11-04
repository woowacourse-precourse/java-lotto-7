package lotto.lotto.service;

import java.util.List;
import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.LottoWinning;
import lotto.lotto.domain.value.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankCalculatorTest {

    private LottoRankCalculator lottoRankCalculator;
    private Lotto lotto;
    private Lotto bonusLotto;

    @BeforeEach
    void setUp() {
        lottoRankCalculator = new LottoRankCalculator();
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusLotto = new Lotto(List.of(1, 2, 3, 4, 5, 16));
    }

    @Test
    @DisplayName("lotto의 rank를 평가한다.")
    void calculateRankTest() {
        // given
        LottoWinning lottoWinning = LottoWinning.of(lotto, 7);

        // when
        LottoRank lottoRank = lottoRankCalculator.calculateRank(lotto, lottoWinning);

        // then
        Assertions.assertThat(lottoRank).isEqualTo(LottoRank.MATCHED6);
    }

    @Test
    @DisplayName("bouns number를 갖고 lotto의 rank를 평가한다.")
    void calculateRankWithBonusNumberTest() {
        // given
        LottoWinning lottoWinning = LottoWinning.of(bonusLotto, 6);

        // when
        LottoRank lottoRank = lottoRankCalculator.calculateRank(lotto, lottoWinning);

        // then
        Assertions.assertThat(lottoRank).isEqualTo(LottoRank.MATCHED5_BONUS);
    }
}