package lotto.domain.winning;

import static lotto.domain.winning.LottoRank.FIFTH;
import static lotto.domain.winning.LottoRank.FIRST;
import static lotto.domain.winning.LottoRank.FOURTH;
import static lotto.domain.winning.LottoRank.NONE;
import static lotto.domain.winning.LottoRank.SECOND;
import static lotto.domain.winning.LottoRank.THIRD;
import static lotto.domain.winning.LottoRank.find;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    @DisplayName("일치 개수와 보너스 번호 존재 여부가 주어지면 맞는 등수를 조회한다.")
    @MethodSource(value = "provideMatchingCountAndHasNumberWithExpectedRank")
    @ParameterizedTest
    void 로또_등수_조회(int matchingCount, boolean hasNumber, LottoRank expectedRank) {
        assertThat(find(matchingCount, hasNumber)).isEqualTo(expectedRank);
    }

    @DisplayName("당첨 개수를 알려주면 총 당첨 금액을 계산한다.")
    @MethodSource(value = "provideRankAndExpectedWinningMoneyTotal")
    @ParameterizedTest
    void 로또_등수별_총_당첨_금액_계산(LottoRank lottoRank, long expectedWinningMoneyTotal) {
        assertThat(lottoRank.calculateWinningMoneyTotal(1L)).isEqualTo(expectedWinningMoneyTotal);
    }

    static Stream<Arguments> provideMatchingCountAndHasNumberWithExpectedRank() {
        return Stream.of(
                Arguments.of(0, true, NONE),
                Arguments.of(1, true, NONE),
                Arguments.of(2, true, NONE),
                Arguments.of(3, true, FIFTH),
                Arguments.of(3, false, FIFTH),
                Arguments.of(4, true, FOURTH),
                Arguments.of(5, false, THIRD),
                Arguments.of(5, true, SECOND),
                Arguments.of(6, false, FIRST)
        );
    }

    static Stream<Arguments> provideRankAndExpectedWinningMoneyTotal() {
        return Stream.of(
                Arguments.of(FIFTH, 5_000L),
                Arguments.of(FOURTH, 50_000L),
                Arguments.of(THIRD, 1_500_000L),
                Arguments.of(SECOND, 30_000_000L),
                Arguments.of(FIRST, 2_000_000_000L)
        );
    }

}
