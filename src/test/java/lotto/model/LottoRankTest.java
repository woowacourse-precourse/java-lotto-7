package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

    @DisplayName("당첨 번호 일치 개수와 보너스 번호의 일치 여부로 로또 순위를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, NO_LUCK"
    })
    void matchRank(int numberMatchCount, boolean bonusNumberMatch, LottoRank lank) {
        //when
        LottoRank lottoRank = LottoRank.matchRank(numberMatchCount, bonusNumberMatch);

        //then
        assertThat(lottoRank).isEqualTo(lank);
    }
}
