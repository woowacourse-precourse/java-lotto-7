package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    public void setup() {
        inputValidator = new InputValidator();
    }

    @DisplayName("입력된 값이 정수가 아닐 경우 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"100j", "999999999999", "abcd", "가나다라"})
    public void 입력된_값이_정수가_아닐_경우_에러가_발생한다(String input) {
        assertThatThrownBy(() -> {
            inputValidator.validateInputMoney(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}