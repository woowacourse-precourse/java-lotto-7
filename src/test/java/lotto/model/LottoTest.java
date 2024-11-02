package lotto.model;

import static lotto.constant.ErrorMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.constant.ErrorMessage.INVALID_LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("== Lotto 테스트 ==")
class LottoTest {
    @Nested
    @DisplayName("-- 기능 테스트 --")
    class FeatureTest {
        @ParameterizedTest
        @DisplayName("오름차순으로 정렬")
        @MethodSource("sortAscendingArguments")
        void 오름차순으로_정렬(List<Integer> numbers, List<String> sorted) {
            Lotto lotto = new Lotto(numbers);

            assertIterableEquals(lotto.toSortedStrings(), sorted);
        }

        static Stream<Arguments> sortAscendingArguments() {
            return Stream.of(
                    Arguments.of(List.of(6, 3, 4, 2, 5, 1), List.of("1", "2", "3", "4", "5", "6")),
                    Arguments.of(List.of(11, 15, 1, 45, 2, 3), List.of("1", "2", "3", "11", "15", "45"))
            );
        }

        @ParameterizedTest
        @DisplayName("숫자를 가지고 있는지")
        @MethodSource("validateContainsArguments")
        void 로또_번호가_중복됨(List<Integer> numbers, final int toCheck, final boolean result) {
            Lotto lotto = new Lotto(numbers);

            assertThat(lotto.contains(toCheck)).isEqualTo(result);
        }

        static Stream<Arguments> validateContainsArguments() {
            return Stream.of(
                    Arguments.of(List.of(1, 7, 17, 27, 37, 45), 7, true),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, false)
            );
        }

        @ParameterizedTest
        @DisplayName("같은 수 개수 구하기")
        @MethodSource("countMatchArguments")
        void 같은_수_개수(List<Integer> first, List<Integer> second, int matchCount) {
            Lotto lotto = new Lotto(first);
            Lotto toCheck = new Lotto(second);

            assertThat(lotto.countMatch(toCheck)).isEqualTo(matchCount);
        }

        static Stream<Arguments> countMatchArguments() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 6),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7), 5),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 7, 8), 4),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12), 0)
            );
        }
    }

    @Nested
    @DisplayName("-- 예외 테스트 --")
    class ExceptionTest {
        @ParameterizedTest
        @DisplayName("로또 번호의 개수가 6개가 아님")
        @MethodSource("notSixNumbersArguments")
        void 로또_번호의_개수가_6개가_아님(List<Integer> numbers) {
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }

        static Stream<Arguments> notSixNumbersArguments() {
            return Stream.of(
                    Arguments.of(List.of(1)),
                    Arguments.of(List.of(1, 2, 3)),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7))
            );
        }

        @ParameterizedTest
        @DisplayName("로또 번호가 중복됨")
        @MethodSource("duplicatedNumbersArguments")
        void 로또_번호가_중복됨(List<Integer> numbers) {
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(DUPLICATED_LOTTO_NUMBER.getMessage());
        }

        static Stream<Arguments> duplicatedNumbersArguments() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3, 4, 5, 5)),
                    Arguments.of(List.of(7, 7, 7, 7, 7, 7))
            );
        }
    }
}
