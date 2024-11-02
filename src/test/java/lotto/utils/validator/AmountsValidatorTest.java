package lotto.utils.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class AmountsValidatorTest {

    @DisplayName("1000이상 100000이하의 금액이 입력되었을 때, 정상작동한다.")
    @Test
    void Given_AmountsAreCorrect_When_CheckInput_Then_Success() {

        assertThatCode(() -> AmountsValidator.validateLottoAmount("1000"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("빈 문자열이 입력되었다면, 예외 처리된다.")
    @EmptySource
    void Given_AmountsAreEmptyString_When_CheckEmptyAmounts_Then_Error(String input) {
        assertThatThrownBy(() -> AmountsValidator.validateLottoAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_AMOUNT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 값이 입력되었다면, 예외 처리된다.")
    @ValueSource(strings = "asd")
    void Given_AmountsAreNonNumeric_When_CheckNonNumeric_Then_Error(String input) {
        assertThatThrownBy(() -> AmountsValidator.validateLottoAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NON_NUMERIC.getMessage());
    }

    @ParameterizedTest
    @DisplayName("1000원보다 적은 금액이 입력되면, 예외 처리된다.")
    @ValueSource(strings = "999")
    void Given_AmountsAreOverMinAmounts_When_CheckMinAmounts_Then_Error(String input) {
        assertThatThrownBy(() -> AmountsValidator.validateLottoAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.UNDER_MIN_AMOUNTS.getMessage());
    }

    @ParameterizedTest
    @DisplayName("10만원이 넘는 금액이 입력되면, 예외 처리된다.")
    @ValueSource(strings = "100001")
    void Given_AmountsAreOverMaxAmounts_When_CheckMaxAmounts_Then_Error(String input) {
        assertThatThrownBy(() -> AmountsValidator.validateLottoAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OVER_MAX_AMOUNTS.getMessage());
    }

    @ParameterizedTest
    @DisplayName("1000원 단위가 아닌 금액이 입력되면, 예외 처리된다.")
    @ValueSource(strings = "1100")
    void Given_AmountsCanNotDivideByThousand_When_CheckDivisibilityByThousand_Then_Error(String input) {
        assertThatThrownBy(() -> AmountsValidator.validateLottoAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.IS_NOT_DIVISIBLE_BY_THOUSAND_WON.getMessage());
    }
}