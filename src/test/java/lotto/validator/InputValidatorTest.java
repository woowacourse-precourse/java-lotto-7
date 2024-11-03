package lotto.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    private InputValidator validator;

    @BeforeEach
    void setUp() {
        validator = new InputValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "0"})
    @NullSource
    @DisplayName("validateInput 메서드 테스트")
    void 빈_값이나_0을_입력하면_예외가_발생한다(String input) {
        //given
        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInputAmount(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"01000", "9000a", "abc", "-1000", "1000.50", "1000 ", " 5000"})
    void 숫자가_아닌_문자를_입력하면_예외가_발생한다(String input) {
        //given
        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInputAmount(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1500", "160001","199999"})
    void 천_원_단위로_나누어_떨어지지_않으면_예외가_발생한다(String input) {
        //given
        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInputAmount(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "160000","5000000","123000"})
    void 천_원_단위로_나누어_떨어지는_숫자_입력_시_테스트를_성공한다(String input) {
        //given
        //when & then
        assertDoesNotThrow(() -> validator.validateInputAmount(input));
    }


}