package lotto.util.validator;

import lotto.exception.InputError;
import lotto.exception.InputException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("[VALIDATOR TEST] - Input")
class InputValidatorTest {

    @Nested
    @DisplayName("<Success Test>")
    class 성공_테스트 {

        @ParameterizedTest(name = "({index}) {0}")
        @ValueSource(strings = {
                "1", "49", "10", "0", "100"
        })
        @DisplayName("올바른 형식의 로또 번호 입력 시, 예외가 발생하지 않는다.")
        void 올바른_형식의_로또_번호값을_입력할_경우_정상_종료된다(
                // given
                String givenLottoNumberInput
        ) {
            // when & then
            assertThatCode(() -> InputValidator.validateLottoNumberInput(givenLottoNumberInput))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest(name = "({index}) {0}")
        @ValueSource(strings = {
            "1", "1000", "1000000", "0", "123", "123456"
        })
        @DisplayName("올바른 형식의 금액 입력 시, 예외가 발생하지 않는다.")
        void 올바른_형식의_금액값을_입력할_경우_정상_종료된다(
                // given
                String givenMoneyInput
        ) {
            // when & then
            assertThatCode(() -> InputValidator.validateMoneyInput(givenMoneyInput))
                    .doesNotThrowAnyException();
        }

    }
    @Nested
    @DisplayName("<Fail Test>")
    class 실패_테스트 {
        @ParameterizedTest(name = "({index}) {0} ==> InputException")
        @ValueSource(strings = {
                "ㄱㄴㄷ", "abc", "1234a", "1.2.3.4", "1&2&3"
        })
        @DisplayName("올바른 형식의 로또 번호 입력 시, 예외가 발생하지 않는다.")
        void 잘못된_형식의_로또_번호값을_입력할_경우_예외를_발생시킨다(
                // given
                String givenLottoNumberInput
        ) {
            // when & then
            assertThatCode(() -> InputValidator.validateLottoNumberInput(givenLottoNumberInput))
                    .isInstanceOf(InputException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageStartingWith("[ERROR]")
                    .hasMessageContaining(InputError.INVALID_FORMAT.getMessage());
        }

        @ParameterizedTest(name = "({index}) {0} ==> InputException")
        @ValueSource(strings = {
                "ㄱㄴㄷ", "abc", "1234a", "1.2.3.4", "1&2&3"
        })
        @DisplayName("올바른 형식의 금액 입력 시, 예외가 발생하지 않는다.")
        void 잘못된_형식의_금액값을_입력할_경우_예외를_발생시킨다(
                // given
                String givenMoneyInput
        ) {
            // when & then
            assertThatCode(() -> InputValidator.validateMoneyInput(givenMoneyInput))
                    .isInstanceOf(InputException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageStartingWith("[ERROR]")
                    .hasMessageContaining(InputError.INVALID_FORMAT.getMessage());
        }

        @ParameterizedTest(name = "({index}) {0} ==> InputException")
        @NullSource
        @EmptySource
        void 빈_값을_입력할_경우_예외를_발생시킨다(
                // given
                String givenInput
        ){
            // when & then
            assertThatCode(() -> InputValidator.validateLottoNumberInput(givenInput))
                    .isInstanceOf(InputException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageStartingWith("[ERROR]")
                    .hasMessageContaining(InputError.NOT_ALLOW_EMPTY.getMessage());

            assertThatCode(() -> InputValidator.validateMoneyInput(givenInput))
                    .isInstanceOf(InputException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageStartingWith("[ERROR]")
                    .hasMessageContaining(InputError.NOT_ALLOW_EMPTY.getMessage());
        }
    }

}