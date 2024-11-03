package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("번호 일치 횟수에 맞게 등수를 반환해야 한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,false,NONE",
            "3,false,FIFTH",
            "4,false,FOURTH",
            "5,false,THIRD",
            "5,true,SECOND",
            "6,false,FIRST"
    })
    void should_calculateLottoRank_When_MatchingCountAndBonusGiven(
            int matchCount,
            boolean hasBonusNumber,
            LottoRank expected
    ) {
        // given
        LottoRank lottoRank;

        // when
        lottoRank = LottoRank.getLottoRank(matchCount, hasBonusNumber);

        // then
        assertThat(lottoRank).isEqualTo(expected);
    }
}