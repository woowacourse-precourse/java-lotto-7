package lotto.validator;

import lotto.enums.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumValidatorTest {
    WinningNumValidator winningNumValidator = new WinningNumValidator();

    @DisplayName("번호의 갯수가 6개가 아니면 예외 발생")
    @Test
    void validNumberOfLottoNumTest() {
        String input1 = "1,2,3,4,5";
        Assertions.assertThatThrownBy(() -> winningNumValidator.validate(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_NUMBER_OF_WINNING_NUMBERS.getMessage());

        String input2 = "1,2,3,4,5,6,7";
        Assertions.assertThatThrownBy(() -> winningNumValidator.validate(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_NUMBER_OF_WINNING_NUMBERS.getMessage());

    }

    @DisplayName("정수가 아닌 입력이 들어오면 예외 발생")
    @Test
    void notIntTest() {
        String input = "1,2,3,4,5,육";

        Assertions.assertThatThrownBy(() -> winningNumValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_INT.getMessage());
    }


    @DisplayName("범위내의 정수가 아닌 입력이 들어오면 예외 발생")
    @Test
    void invalidRangeTest() {
        String input = "1,2,3,4,5,46";

        Assertions.assertThatThrownBy(() -> winningNumValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUM_RANGE.getMessage());
    }


    @DisplayName("중복된 입력이 들어오면 예외 발생")
    @Test
    void inValidDuplicateTest() {
        String input = "1,2,3,4,5,5";

        Assertions.assertThatThrownBy(() -> winningNumValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_WINNING_NUM_DUPLICATE.getMessage());
    }
}