package lotto.validator;

import lotto.enums.ExceptionMessage;
import lotto.utils.InputHandler;
import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusNumValidatorTest {
    BonusNumValidator bonusNumValidator = new BonusNumValidator();

    @DisplayName("정수가 아닌 입력이 들어오면 예외 발생")
    @Test
    void notIntTest(){
        String input = "삼";
        Assertions.assertThatThrownBy(() -> bonusNumValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_INT.getMessage());
    }

    @DisplayName("범위내의 정수가 아닌 입력이 들어오면 예외 발생")
    @Test
    void invalidRangeTest(){
        String input = "46";
        Assertions.assertThatThrownBy(() -> bonusNumValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUM_RANGE.getMessage());
    }
}