package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;

class LottoResultCheckerTest {

    @ParameterizedTest
    @MethodSource("provideNumbersForMatching")
    @DisplayName("로또 번호와 당첨 번호를 비교하여 일치하는 숫자의 개수를 반환")
    void countMatchingNumbers_shouldReturnCorrectCount(List<Integer> lottoNumbers,
                                                       List<Integer> winningNumbers, int expectedCount) {
        // when
        int matchCount = LottoResultChecker.countMatchingNumbers(lottoNumbers, winningNumbers);

        // then
        assertThat(matchCount).isEqualTo(expectedCount);
    }

    private static List<Arguments> provideNumbersForMatching() {
        return Arrays.asList(
                // 6개 모두 일치하는 경우
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6),
                        6
                ),
                // 일부만 일치하는 경우
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 7, 8, 9),
                        3
                ),
                // 하나도 일치하지 않는 경우
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(7, 8, 9, 10, 11, 12),
                        0
                ),
                // 순서가 다르지만 같은 숫자인 경우
                Arguments.of(
                        List.of(6, 5, 4, 3, 2, 1),
                        List.of(1, 2, 3, 4, 5, 6),
                        6
                ),
                // 5개 일치하는 경우
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 7),
                        List.of(1, 2, 3, 4, 5, 6),
                        5
                ),
                // 4개 일치하는 경우
                Arguments.of(
                        List.of(1, 2, 3, 4, 7, 8),
                        List.of(1, 2, 3, 4, 5, 6),
                        4
                ),
                // 3개 일치하는 경우
                Arguments.of(
                        List.of(1, 2, 3, 7, 8, 9),
                        List.of(1, 2, 3, 4, 5, 6),
                        3
                )
        );
    }
}
