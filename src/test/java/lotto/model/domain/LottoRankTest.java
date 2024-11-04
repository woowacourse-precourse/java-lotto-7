package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, FAIL"
    })
    @DisplayName("매칭 개수와 보너스 적중 여부에 맞는 등수를 반환한다.")
    void testCreateCorrectLottoRank(int matchCount, boolean isBonusMatched, LottoRank lottoRank) {
        assertThat(LottoRank.of(matchCount, isBonusMatched)).isEqualTo(lottoRank);
    }

    @ParameterizedTest
    @CsvSource({
            "FIRST, 6, false, 2000000000",
            "SECOND, 5, true, 30000000",
            "THIRD, 5, false, 1500000",
            "FOURTH, 4, false, 50000",
            "FIFTH, 3, false, 5000",
            "FAIL, 0, false, 0"
    })
    @DisplayName("각 로또 등수는 올바른 매칭 개수와 상금을 가지고 있다.")
    void testLottoRank(LottoRank lottoRank, int matchCount, boolean isBonusMatched, int prize) {
        assertThat(lottoRank.getMatchCount()).isEqualTo(matchCount);
        assertThat(lottoRank.isBonusMatched()).isEqualTo(isBonusMatched);
        assertThat(lottoRank.getPrize()).isEqualTo(prize);
    }
}