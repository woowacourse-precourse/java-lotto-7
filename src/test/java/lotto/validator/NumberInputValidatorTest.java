package lotto.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberInputValidatorTest {

    private NumberInputValidator numberInputValidator;

    @BeforeEach
    void beforeEach() {
        this.numberInputValidator = new NumberInputValidator();
    }

    @Test
    @DisplayName("숫자 형태가 아닌 입력일 경우")
    void 숫자_형태가_아닌_입력일_경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                numberInputValidator.validateNumberInput("d1"));
    }

    @Test
    @DisplayName("정수 범위를 넘어간 입력일 경우")
    void 정수_범위를_넘어간_입력일_경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                numberInputValidator.validateNumberInput("376278462138746872"));
    }
}
