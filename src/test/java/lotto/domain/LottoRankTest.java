package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {
    @ParameterizedTest
    @CsvSource({"6, false, FIRST", "5, true, SECOND", "5, false, THIRD", "4, false, FOURTH", "3, false, FIFTH"})
    void 로또_등수_구학기(int matchCount, boolean isBonus, LottoRank excepted) {
        //given @CsvSource를 통해 주어짐

        //when
        final LottoRank lottoRank = LottoRank.get(matchCount, isBonus);

        //then
        Assertions.assertThat(lottoRank).isEqualTo(excepted);
    }
}