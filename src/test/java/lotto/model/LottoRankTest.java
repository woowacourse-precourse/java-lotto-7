package lotto.model;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    @DisplayName("일치하는 수와 보너스 일치 여부에 해당하는 등수를 반환할 수 있다.")
    @ParameterizedTest
    @MethodSource("generateMatchRankSources")
    void 일치하는_수와_보너스_일치_여부에_해당하는_등수를_반환할_수_있다(int matchCount, boolean matchBonus, LottoRank expectedRank) {
        // when
        LottoRank actualRank = LottoRank.by(matchCount, matchBonus);

        // then
        Assertions.assertThat(actualRank).isEqualTo(expectedRank);
    }

    @DisplayName("일치하는 수가 3 미만이면 보너스 일치 여부와 관계없이 LOSE를 반환한다.")
    @ParameterizedTest
    @MethodSource("generateMatchCountLessThanThree")
    void 일치하는_수가_2_이하이면_보너스_일치_여부와_관계없이_LOSE를_반환한다(int matchCount, boolean matchBonus) {
        // when
        LottoRank actualRank = LottoRank.by(matchCount, matchBonus);

        // then
        Assertions.assertThat(actualRank).isEqualTo(LottoRank.LOSE);
    }

    @DisplayName("일치하는 수가 3 이상이고 보너스 일치 여부에 해당하는 등수가 없다면 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateNotExistMatchRankSources")
    void 일치하는_수가_3_이상이고_보너스_일치_여부에_해당하는_등수가_없다면_에러가_발생한다(int matchCount, boolean matchBonus) {
        Assertions.assertThatThrownBy(() -> {
            LottoRank.by(matchCount, matchBonus);
        }).isInstanceOf(IllegalStateException.class);
    }

    private static Stream<Arguments> generateMatchRankSources() {
        return Stream.of(
                Arguments.of(3, false, LottoRank.RANK_5),
                Arguments.of(4, false, LottoRank.RANK_4),
                Arguments.of(5, false, LottoRank.RANK_3),
                Arguments.of(5, true, LottoRank.RANK_2),
                Arguments.of(6, false, LottoRank.RANK_1)
        );
    }

    private static Stream<Arguments> generateMatchCountLessThanThree() {
        return Stream.of(
                Arguments.of(0, true),
                Arguments.of(0, false),
                Arguments.of(1, true),
                Arguments.of(1, false),
                Arguments.of(2, true),
                Arguments.of(2, false)
        );
    }

    private static Stream<Arguments> generateNotExistMatchRankSources() {
        return Stream.of(
                Arguments.of(3, true),
                Arguments.of(4, true),
                Arguments.of(6, true),
                Arguments.of(7, false),
                Arguments.of(7, true)
        );
    }
}