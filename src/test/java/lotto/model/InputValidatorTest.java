package lotto.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.message.ExceptionMessage;
import lotto.model.domain.InputValidator;
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
                .hasMessage(ExceptionMessage.EMPTY_INPUT_EXCEPTION);
    }

    @DisplayName("숫자 외 문자 입력 테스트(구입 금액)")
    @ParameterizedTest
    @ValueSource(strings = {"팔천", "2000원", " 8000", "abc", "$", "-20000"})
    void invalidCharacterTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_AMOUNT_CHARACTER_INPUT_EXCEPTION);
    }

    @DisplayName("최대 범위 초과 입력 테스트(구입 금액)")
    @ParameterizedTest
    @ValueSource(strings = {"21474836482"})
    void exceedMaxAreaTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EXCEED_MAX_AREA_EXCEPTION);
    }

    @DisplayName("최소 금액 미만 입력 테스트(구입 금액)")
    @ParameterizedTest
    @ValueSource(strings = {"100", "0", "999"})
    void minAmountTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.UNDER_MIN_AMOUNT_INPUT_EXCEPTION);
    }

    @DisplayName("1000원 단위 입력 테스트(구입 금액)")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "2200", "11111"})
    void amountUnitTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_AMOUNT_UNIT_EXCEPTION);
    }

    @DisplayName("구입 금액 정상 입력 테스트(구입 금액)")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "8000", "100000"})
    void validAmountTest(String input) {
        assertThatCode(() -> inputValidator.validateInputAmount(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("빈 입력 테스트(당첨 번호)")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyWinningNumberTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EMPTY_INPUT_EXCEPTION);
    }


    @DisplayName("유효 문자 입력 테스트(당첨 번호)")
    @ParameterizedTest
    @ValueSource(strings = {"팔,2", " 8,2,3", "a,2", "abc", "$", "-2,1,3"})
    void invalidWinningNumberCharacterTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_WINNING_NUMBER_CHARACTER_INPUT_EXCEPTION);
    }

    @DisplayName("빈 구분된 값 테스트(당첨 번호)")
    @ParameterizedTest
    @ValueSource(strings = {"1,,2,3,4", "1,,,2,3,4"})
    void invalidSeparatedNumberTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_SEPARATOR_NUMBER_EXCEPTION);
    }

    @DisplayName("포맷(시작,끝 구분자) 테스트(당첨 번호)")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,", ",1,2", ",1,2,"})
    void validateFormatTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT_EXCEPTION);
    }

    @DisplayName("정상 보너스 번호 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"8"})
    void validBonusNumberTest(String input) {
        assertThatCode(() -> inputValidator.validateInputBonusNumber(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호 입력으로 숫자 외 문자를 입력받으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"팔", "8,", " 8", "abc", "$", "-20"})
    void invalidBonusNumberCharacterTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_BONUS_NUMBER_CHARACTER_INPUT_EXCEPTION);
    }
}