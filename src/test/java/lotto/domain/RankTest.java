package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @DisplayName("당첨과 보너스 숫자를 몇개 맞췄는가를 기준으로 랭킹을 판단한다.")
    @ParameterizedTest
    @MethodSource("provideCountsAndMonth")
    void 당첨과_보너스_숫자를_몇개_맞췄는가를_기준으로_랭킹을_판단한다(int basicCount, int bonusCount, Rank rank) {
        assertThat(Rank.calculateRank(basicCount, bonusCount)).isEqualTo(rank);
    }

    static Stream<Arguments> provideCountsAndMonth() {
        return Stream.of(
                Arguments.of(Rank.FIRST.getBasicCount(), Rank.FIRST.getBonusCount(), Rank.FIRST),
                Arguments.of(Rank.SECOND.getBasicCount(), Rank.SECOND.getBonusCount(), Rank.SECOND),
                Arguments.of(Rank.THIRD.getBasicCount(), Rank.THIRD.getBonusCount(), Rank.THIRD),
                Arguments.of(Rank.FOURTH.getBasicCount(), Rank.FOURTH.getBonusCount(), Rank.FOURTH),
                Arguments.of(Rank.FIFTH.getBasicCount(), Rank.FIFTH.getBonusCount(), Rank.FIFTH),
                Arguments.of(Rank.NONE.getBasicCount(), Rank.NONE.getBonusCount(), Rank.NONE)
        );
    }
}