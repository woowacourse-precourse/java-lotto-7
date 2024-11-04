package lotto.service.input.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorServiceTest {

    private CommonValidatorService commonValidator = new CommonValidatorService();

    @Test
    @DisplayName("null 값 입력 시 예외 발생 테스트")
    void nullInput() {
        String input = null;
        assertThatThrownBy(() -> commonValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 값 입력 시 예외 발생 테스트")
    void vacant() {
        String input = "";
        assertThatThrownBy(() -> commonValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백 문자 포함 입력 시 예외 발생 테스트1")
    void whiteSpace() {
        String input = "\t";
        assertThatThrownBy(() -> commonValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백 문자 포함 입력 시 예외 발생 테스트2")
    void whiteSpace2() {
        String input = "\t1";
        assertThatThrownBy(() -> commonValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }
}