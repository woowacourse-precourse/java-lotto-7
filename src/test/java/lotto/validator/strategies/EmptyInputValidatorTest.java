package lotto.validator.strategies;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EmptyInputValidatorTest {

    private final EmptyInputValidator validator = new EmptyInputValidator();

    @ParameterizedTest
    @CsvSource({
            "'', EMPTY_INPUT_INVALID",    // 빈 문자열
            "'   ', EMPTY_INPUT_INVALID"  // 공백 문자열
    })
    void validate_WhenInputEmptyOrBlank_ShouldThrowException(String input, String errorMessage) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(input))
                .withMessage(ErrorMessage.valueOf(errorMessage).getMessage());
    }

    @Test
    void validate_WhenInputIsNull_ShouldThrowException() {
        // null은 CsvSource로 직접 전달할 수 없기 때문에 별도의 테스트 메서드에서 검증
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(null))
                .withMessage(ErrorMessage.EMPTY_INPUT_INVALID.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "'valid input'",  // 정상 입력
            "'another valid input'" // 정상 입력
    })
    void validate_WhenInputValid_ShouldNotThrowException(String input) {
        assertThatNoException().isThrownBy(() -> validator.validate(input));
    }

}
