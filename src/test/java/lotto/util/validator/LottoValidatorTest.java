package lotto.util.validator;

import lotto.exception.LottoError;
import lotto.exception.LottoException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("[VALIDATOR TEST] - Lotto")
class LottoValidatorTest {

    @Nested
    @DisplayName("<Success Test>")
    class 성공_테스트 {

        @ParameterizedTest(name = "({index}) {0}")
        @ValueSource(ints = {
                1, 45
        })
        @DisplayName("올바른 범위의 로또 번호일 경우, 정상 종료된다.")
        void 올바른_범위의_로또_번호일_경우_정상_종료된다(
                // given
                int givenNumber
        ) {
            // when & then
            assertThatCode(() -> LottoValidator.validateNumber(givenNumber))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("1~45 범위 내의 중복 없는 숫자 6개일 경우, 정상 종료된다.")
        void 올바른_범위_갯수_중복없는_로또_번호들만_존재할_경우_정상_종료된다() {
            // given
            List<Integer> givenNumbers = List.of(1, 2, 3, 4, 5, 6);

            // when & then
            assertThatCode(() -> LottoValidator.validateNumbers(givenNumbers))
                    .doesNotThrowAnyException();
        }

    }

    @Nested
    @DisplayName("<Fail Test>")
    class 실패_테스트 {

        @ParameterizedTest(name = "({index}) {0}")
        @ValueSource(ints = {
                0, 46
        })
        @DisplayName("로또 번호 범위가 1~45에 벗어날 경우, 예외가 발생한다.")
        void 올바른_범위의_로또_번호일_경우_정상_종료된다(
                // given
                int givenNumber
        ) {
            // when & then
            assertThatCode(() -> LottoValidator.validateNumber(givenNumber))
                    .isInstanceOf(LottoException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageStartingWith("[ERROR]")
                    .hasMessageContaining(LottoError.NUMBER_OUT_OF_RANGE.getMessage());
        }

        @ParameterizedTest(name = "({index}) {0}")
        @MethodSource("invalidNumbersOverRange")
        @DisplayName("로또 번호들 중 범위가 1~45에 벗어날 경우, 예외가 발생한다.")
        void 범위를_벗어난_로또_번호가_존재할_경우_예외를_발생시킨다(
                // given
                List<Integer> givenNumbers
        ) {
            // when & then
            assertThatCode(() -> LottoValidator.validateNumbers(givenNumbers))
                    .isInstanceOf(LottoException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageStartingWith("[ERROR]")
                    .hasMessageContaining(LottoError.NUMBER_OUT_OF_RANGE.getMessage());
        }
        static Stream<Arguments> invalidNumbersOverRange() {
            return Stream.of(
                    Arguments.of(
                            List.of(1, 2, 3, 4, 5, 46)
                    ),
                    Arguments.of(
                            List.of(0, 1, 2, 3, 4, 5)
                    ),
                    Arguments.of(
                            List.of(45, 46, 47, 48, 49, 50)
                    )
            );
        }

        @ParameterizedTest(name = "({index}) {0}")
        @MethodSource("invalidNumbersDuplicated")
        @DisplayName("로또 번호들 중 중복된 번호가 있을 경우, 예외가 발생한다.")
        void 중복된_로또_번호가_존재할_경우_예외를_발생시킨다(
                // given
                List<Integer> givenNumbers
        ) {
            // when & then
            assertThatCode(() -> LottoValidator.validateNumbers(givenNumbers))
                    .isInstanceOf(LottoException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageStartingWith("[ERROR]")
                    .hasMessageContaining(LottoError.NUMBER_DUPLICATED.getMessage());
        }
        static Stream<Arguments> invalidNumbersDuplicated() {
            return Stream.of(
                    Arguments.of(
                            List.of(1, 1, 3, 4, 5, 6)
                    ),
                    Arguments.of(
                            List.of(1, 2, 3, 4, 5, 5)
                    ),
                    Arguments.of(
                            List.of(1, 2, 3, 4, 45, 45)
                    )
            );
        }

        @ParameterizedTest(name = "({index}) {0}")
        @MethodSource("invalidNumbersNotSix")
        @DisplayName("로또 번호 갯수가 6개가 아닐 경우, 예외가 발생한다.")
        void 로또_번호가_6개가_아닐_경우_예외를_발생시킨다(
                // given
                List<Integer> givenNumbers
        ) {
            // when & then
            assertThatCode(() -> LottoValidator.validateNumbers(givenNumbers))
                    .isInstanceOf(LottoException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageStartingWith("[ERROR]")
                    .hasMessageContaining(LottoError.NUMBERS_WRONG_SIZE.getMessage());
        }
        static Stream<Arguments> invalidNumbersNotSix() {
            return Stream.of(
                    Arguments.of(
                            List.of(1, 2, 3, 4, 5)
                    ),
                    Arguments.of(
                            List.of(1, 2, 3, 4, 5, 6, 7)
                    )
            );
        }
    }

}