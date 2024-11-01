package lotto.model.InputValidatorTest;

import lotto.model.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputWinningNumberTest {
    private InputValidator inputValidator;

    @BeforeEach
    public void setup() {
        inputValidator = new InputValidator();
    }

    @DisplayName("당첨 번호가 6개가 아닐 경우 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"'1'", "'1,2'", "'1,2,3'", "'1,2,3,4'", "'1,2,3,4,5'"})
    public void 당첨_번호가_6개가_아닐_경우_에러가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> {
            inputValidator.validateInputWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복될 경우 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"'1,2,2,3,4,5'", "'1,1,1,1,1,1'", "'29,30,31,32,33,30'"})
    public void 당첨_번호가_중복될_경우_에러가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> {
            inputValidator.validateInputWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
