package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @DisplayName("로또 등수 계산 테스트")
    @ParameterizedTest
    @MethodSource("results")
    void calculateRank(int match,boolean isMatchBonus,Rank expectRank) {
        Rank lottoRank = Rank.calculateRank(match, isMatchBonus);
        assertThat(lottoRank).isEqualTo(expectRank);
    }

    static Stream<Arguments> results() {
        return Stream.of(
                Arguments.of(6,true,Rank.FIRST),
                Arguments.of(6,false,Rank.FIRST),
                Arguments.of(5,true,Rank.SECOND),
                Arguments.of(5,false,Rank.THIRD),
                Arguments.of(4,true,Rank.FOURTH),
                Arguments.of(4,false,Rank.FOURTH),
                Arguments.of(3,true,Rank.FIFTH),
                Arguments.of(3,false,Rank.FIFTH),
                Arguments.of(1,true,null),
                Arguments.of(1,false,null),
                Arguments.of(0,true,null),
                Arguments.of(0,false,null)
        );
    }

}
