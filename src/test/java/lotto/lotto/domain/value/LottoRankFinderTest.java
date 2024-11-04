package lotto.lotto.domain.value;

import lotto.lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankFinderTest {

    @Test
    @DisplayName("1개 일치하고, bonusBall이 일치하지 않을 때 FAIL을 return 한다.")
    void match1ReturnFAILvalue() {
        Assertions.assertThat(LottoRankFinder.findLottoRankByMatchCount(1, false)).isEqualTo(LottoRank.FAIL);
    }

    @Test
    @DisplayName("2개 일치하고, bonusBall이 일치하지 않을 때 FAIL을 return 한다.")
    void match2ReturnFAILvalue() {
        Assertions.assertThat(LottoRankFinder.findLottoRankByMatchCount(2, false)).isEqualTo(LottoRank.FAIL);
    }

    @Test
    @DisplayName("3개 일치하고, bonusBall이 일치하지 않을 때 MATCH3을 return 한다.")
    void match3ReturnMATCH3value() {
        Assertions.assertThat(LottoRankFinder.findLottoRankByMatchCount(3, false)).isEqualTo(LottoRank.MATCHED3);
    }

    @Test
    @DisplayName("4개 일치하고, bonusBall이 일치하지 않을 때 MATCH4을 return 한다.")
    void match4ReturnMATCH4value() {
        Assertions.assertThat(LottoRankFinder.findLottoRankByMatchCount(4, false)).isEqualTo(LottoRank.MATCHED4);
    }

    @Test
    @DisplayName("5개 일치하고, bonusBall이 일치하지 않을 때 MATCH5을 return 한다.")
    void match5withBonusBallReturnMATCH5_BONUSvalue() {
        Assertions.assertThat(LottoRankFinder.findLottoRankByMatchCount(5, true)).isEqualTo(LottoRank.MATCHED5_BONUS);
    }

    @Test
    @DisplayName("5개 일치하고, bonusBall이 일치할 때 MATCH5_BONUS를 return 한다.")
    void match5ReturnMATCH5value() {
        Assertions.assertThat(LottoRankFinder.findLottoRankByMatchCount(6, false)).isEqualTo(LottoRank.MATCHED6);
    }

    @Test
    @DisplayName("6개 일치하고, bonusBall이 일치하지 않을 때 MATCH6을 return 한다.")
    void match6returnMATCH6value() {

    }
}