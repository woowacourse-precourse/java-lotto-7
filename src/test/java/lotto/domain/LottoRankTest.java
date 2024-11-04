package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @ParameterizedTest
    @MethodSource("로또_번호_일치_개수와_보너스_번호_일치_여부")
    void 로또_번호_일치_개수와_보너스_번호_일치_여부로_로또_순위를_찾을_수_있다(int matchCount,
                                                   boolean isBonusNumber,
                                                   LottoRank expectedRank) {
        //when
        LottoRank lottoRank = valueOf(matchCount, isBonusNumber);

        //then
        assertThat(lottoRank).isEqualTo(expectedRank);
    }

    @ParameterizedTest
    @MethodSource("로또_번호_일치_개수와_보너스_번호_일치_여부_찾을_수_없음")
    void 로또_번호_일치_개수와_보너스_번호_일치_여부가_일치하지_않으면_랭크가_없음을_반환한다(int matchCount,
                                                   boolean isBonusNumber,
                                                   LottoRank expectedRank) {
        //when
        LottoRank lottoRank = valueOf(matchCount, isBonusNumber);

        //then
        assertThat(lottoRank).isEqualTo(expectedRank);
    }

    static Stream<Arguments> 로또_번호_일치_개수와_보너스_번호_일치_여부() {
        return Stream.of(
                Arguments.of(6, false, FIRST),
                Arguments.of(5, true, SECOND),
                Arguments.of(5, false, THIRD),
                Arguments.of(4, false, FOURTH),
                Arguments.of(3, false, FIFTH)
        );
    }

    static Stream<Arguments> 로또_번호_일치_개수와_보너스_번호_일치_여부_찾을_수_없음() {
        return Stream.of(
                Arguments.of(0, false, NO_RANK),
                Arguments.of(1, false, NO_RANK),
                Arguments.of(2, false, NO_RANK)
        );
    }
}