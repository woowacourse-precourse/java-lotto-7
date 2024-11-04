package lotto.domain;

import static lotto.constant.ErrorMessage.NUMBER_DUPLICATE_ERROR_MESSAGE;
import static lotto.constant.ErrorMessage.NUMBER_RANGE_ERROR_MESSAGE;
import static lotto.constant.ErrorMessage.NUMBER_SIZE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @Nested
    @DisplayName("로또를 만들때")
    class initLottoTest {

        @Test
        @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
        void lottoSizeOver6ErrorTest() {
            assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NUMBER_SIZE_ERROR_MESSAGE.getMessage());
        }

        @ParameterizedTest
        @MethodSource("provideInvalidNumbers")
        @DisplayName("로또 번호가 1보다 작거나 45보다 크면 예외가 발생한다")
        void LottoTest(List<Integer> invalidNumbers) {
            assertThatThrownBy(() -> Lotto.of(invalidNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format(NUMBER_RANGE_ERROR_MESSAGE.getMessage(), 1, 45));
        }

        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
        @Test
        void lottoDuplicateNumberErrorTest() {
            assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NUMBER_DUPLICATE_ERROR_MESSAGE.getMessage());
        }

        public static Stream<List<Integer>> provideInvalidNumbers() {
            return Stream.of(
                    List.of(0, 1, 2, 3, 4, 5),
                    List.of(1, 2, 3, 4, 5, 46)
            );
        }
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    @DisplayName("정수 리스트가 주어지면 해당 숫자들과 일치하는 숫자의 개수를 반환한다.")
    void lottoMatchNumberTest(List<Integer> numbers, int matchedCount) {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        // when
        int result = lotto.getMatchedCount(numbers);
        // then
        assertThat(result).isEqualTo(matchedCount);
    }

    public static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), 4),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), 3)
        );
    }

}
