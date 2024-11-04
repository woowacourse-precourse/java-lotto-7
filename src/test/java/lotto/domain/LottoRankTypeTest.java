package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTypeTest {

    @ParameterizedTest
    @CsvSource({
            "6, false, 2000000000",
            "5, true, 30000000",
            "5, false, 1500000",
            "4, false, 50000",
            "3, false, 5000",
            "0, false, 0"
    })
    @DisplayName("로또 순위가 올바르게 나오는지 확인한다.")
    void validateLottoRank(int matchCount, boolean hasBonusNumber, int price) {
        LottoRankType lottoRankType = LottoRankType.of(matchCount, hasBonusNumber);
        assertThat(lottoRankType.getMatchCount()).isEqualTo(matchCount);
        assertThat(lottoRankType.isHasBonusNumber()).isEqualTo(hasBonusNumber);
        assertThat(lottoRankType.getPrice()).isEqualTo(price);
    }

}