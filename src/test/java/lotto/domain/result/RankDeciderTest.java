package lotto.domain.result;

import static lotto.constants.LottoRank.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[Domain] RankDecider ")
public class RankDeciderTest {

    @Nested
    @DisplayName("[getRank] 로또 순위 결정 기능을 테스트한다")
    class GetRankTest {

        @ParameterizedTest
        @MethodSource("rankTestCases") // given
        @DisplayName("[return] 주어진 매치된 번호 수와 보너스 번호 일치 여부에 따라 올바른 순위를 반환한다")
        public void Given_MatchedNumberCountAndBonus_When_GetRank_Then_ReturnCorrectRank(int matchedNumberCount, boolean isBonusNumberMatched, int expectedRank) {
            // When
            int actualRank = RankDecider.getRank(matchedNumberCount, isBonusNumberMatched);

            // Then
            assertEquals(expectedRank, actualRank);
        }

        private static Object[][] rankTestCases() {
            return new Object[][] {
                    { 0, false, NO_LUCK.getRank() }, // 0개 일치
                    { FIFTH.getMatchCount(), false, FIFTH.getRank() }, // 3개 일치
                    { FOURTH.getMatchCount(), false, FOURTH.getRank() }, // 4개 일치
                    { FOURTH.getMatchCount(), true, FOURTH.getRank() }, // 4개 일치 + 보너스 번호 일치
                    { THIRD.getMatchCount(), false, THIRD.getRank() }, // 5개 일치
                    { SECOND.getMatchCount(), true, SECOND.getRank() }, // 5개 일치 + 보너스 번호 일치
                    { FIRST.getMatchCount(), false, FIRST.getRank() }, // 6개 일치
                    { FIRST.getMatchCount(), true, FIRST.getRank() } // 6개 일치 + 보너스 번호 일치
            };
        }
    }
}
