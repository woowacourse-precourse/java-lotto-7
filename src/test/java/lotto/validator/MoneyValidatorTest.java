package lotto.validator;

import lotto.enums.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyValidatorTest {

    MoneyValidator moneyValidator = new MoneyValidator();

    @DisplayName("정수가 아닌 입력이 들어오면 예외 발생")
    @Test
    void notIntTest(){
        String input = "삼천원";
        Assertions.assertThatThrownBy(() -> moneyValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_INT.getMessage());
    }

    @DisplayName("1000원 단위가 아닌 아닌 입력이 들어오면 예외 발생")
    @Test
    void invalidUnitTest(){
        String input = "3500";
        Assertions.assertThatThrownBy(() -> moneyValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_MONEY_UNIT.getMessage());
    }

    @DisplayName("0원이 입력이 들어오면 예외 발생")
    @Test
    void zeroExceptionTest(){
        String input = "0";
        Assertions.assertThatThrownBy(() -> moneyValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ZERO_EXCEPTION.getMessage());
    }
}