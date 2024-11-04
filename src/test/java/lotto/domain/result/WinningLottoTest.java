package lotto.domain.result;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[Domain] WinningLotto")
public class WinningLottoTest {

    @Nested
    @DisplayName("[getMatchResult] 로또 번호 일치 결과 결정 기능")
    class GetMatchResultTest {

        @ParameterizedTest
        @MethodSource("matchResultTestCases")
        @DisplayName("[return] 주어진 로또 번호 집합에 대해 일치 결과를 반환한다")
        public void Given_LottoNumbers_When_GetMatchResult_Then_ReturnMatchResult(Set<Integer> lottoNumbers, int expectedMatchedCount, boolean expectedIsBonusMatched) {
            // Given
            WinningLotto winningLotto = WinningLotto.create(List.of(1, 2, 3, 4, 5, 6), 7); // 예시로 고정된 번호와 보너스 번호 사용

            // When
            MatchResult result = winningLotto.getMatchResult(lottoNumbers);

            // Then
            assertEquals(expectedMatchedCount, result.getMatchedNumberCount());
            assertEquals(expectedIsBonusMatched, result.isBonusNumberMatched());
        }

        private static Stream<Object[]> matchResultTestCases() {
            return Stream.of(
                    new Object[]{Set.of(1, 2, 3, 4, 5, 6), 6, false}, // 모든 번호 일치, 보너스 번호 불일치
                    new Object[]{Set.of(1, 2, 3, 4, 5, 7), 5, true}, // 번호 5개 일치, 보너스 번호 일치
                    new Object[]{Set.of(1, 2, 3, 8, 9, 10), 3, false}, // 번호 3개 일치, 보너스 번호 불일치
                    new Object[]{Set.of(7, 8, 9, 10, 11, 12), 0, true}, // 번호 일치 없음, 보너스 번호 불일치
                    new Object[]{Set.of(1, 2, 3, 4, 5, 7), 5, true} // 번호 5개 일치, 보너스 번호 일치
            );
        }
    }
}
