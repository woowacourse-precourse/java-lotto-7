package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.constant.ErrorMessage.IS_NOT_NUMBER;
import static lotto.constant.ErrorMessage.IS_NOT_SINGLE_DIGIT;

class InputValidatorTest {

    private static InputValidator inputValidator = new InputValidator();

    @Nested
    @DisplayName("보너스 번호에 대한 입력값을 검증하는 테스트")
    class 보너스_번호_입력값_검증 {

        @ParameterizedTest
        @ValueSource(strings = {"a", "^", "\n"})
        @DisplayName("보너스번호가 숫자가 아닐 경우 예외가 발생한다.")
        void 보너스번호가_숫자가_아닐_경우_예외발생(String bonusNumber) {

            Assertions.assertThatThrownBy(() -> inputValidator.validateBonusNumber(bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(IS_NOT_NUMBER.getValue());

        }

        @ParameterizedTest
        @ValueSource(strings = {" ", "    ", "           "})
        @DisplayName("보너스번호가 공백일 경우 예외가 발생한다.")
        void 보너스번호가_공백일_경우_예외발생(String bonusNumber) {

            Assertions.assertThatThrownBy(() -> inputValidator.validateBonusNumber(bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(IS_NOT_NUMBER.getValue());
        }

        @ParameterizedTest
        @ValueSource(strings = {"27", "375", "99999999999999"})
        @DisplayName("보너스번호가 두 자리 이상일 경우 예외가 발생한다.")
        void 보너스번호가_두자리일_경우_예외발생(String bonusNumber) {
            Assertions.assertThatThrownBy(() -> inputValidator.validateBonusNumber(bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(IS_NOT_SINGLE_DIGIT.getValue());
        }

    }
}


