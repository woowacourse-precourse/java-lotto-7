package lotto.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("빈 입력 테스트(구입 금액)")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyAmountTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.EMPTY_INPUT_EXCEPTION);
    }

    @DisplayName("숫자 외 문자 입력 테스트(구입 금액)")
    @ParameterizedTest
    @ValueSource(strings = {"팔천", "2000원", " 8000", "abc", "$", "-20000"})
    void invalidCharacterTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.INVALID_CHARACTER_INPUT_EXCEPTION);
    }

    @DisplayName("최대 범위 초과 입력 테스트(구입 금액)")
    @ParameterizedTest
    @ValueSource(strings = {"21474836482"})
    void exceedMaxAreaTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.EXCEED_MAX_AREA_EXCEPTION);
    }

    @DisplayName("최소 금액 미만 입력 테스트(구입 금액)")
    @ParameterizedTest
    @ValueSource(strings = {"100", "0", "999"})
    void minAmountTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.UNDER_MIN_AMOUNT_INPUT_EXCEPTION);
    }

    @DisplayName("1000원 단위 입력 테스트(구입 금액)")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "2200", "11111"})
    void amountUnitTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.INVALID_AMOUNT_UNIT_EXCEPTION);
    }

    @DisplayName("정상 구입 금액 입력 테스트(구입 금액)")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "8000", "100000"})
    void validAmountTest(String input) {
        assertThatCode(() -> inputValidator.validateInputAmount(input))
                .doesNotThrowAnyException();
    }
}