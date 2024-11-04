package lotto.service.input.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyInputValidatorServiceTest {

    private final MoneyInputValidatorService moneyInputValidator = new MoneyInputValidatorService();

    @Test
    @DisplayName("숫자가 아닌 문자가 섞여 있을 시 예외 발생 테스트")
    void noneNumeric() {
        String input = "1.";
        assertThatThrownBy(() -> moneyInputValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Long 범위를 넘어가는 입력 시 예외 발생 테스트")
    void overflow() {
        String input = Long.toString(Long.MAX_VALUE +1);
        assertThatThrownBy(() -> moneyInputValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0 입력 시 예외 발생 테스트")
    void zero() {
        String input = "0";
        assertThatThrownBy(() -> moneyInputValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1000 단위로 나누어 떨어지지 않는 값 입력 시 예외 발생 테스트")
    void changeExist() {
        String input = "1999";
        assertThatThrownBy(() -> moneyInputValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }
}