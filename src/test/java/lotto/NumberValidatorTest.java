package lotto;

import lotto.validator.NumberValidator;
import lotto.validator.PriceValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class NumberValidatorTest {
    @DisplayName("문자열이 숫자로만 이루어지지 않으면 예외가 발생한다.")
    @Test
    void stringToInteger() {
        //given
        String case1 = "3300;";
        String case2 = "3300";
        String message = "not integer";

        //when
        final Throwable thrown1 = catchThrowable(() -> {
            NumberValidator.stringToInteger(case1, message);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            NumberValidator.stringToInteger(case2, message);
        });

        //then
        assertThat(thrown1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
        assertThat(thrown2)
                .doesNotThrowAnyException();
    }

    @DisplayName("target이 입력된 범위를 벗어나면 예외가 발생한다.")
    @Test
    void scope() {
        //given
        int case_min = 1;
        int case_max = 3;
        int case1_target = 4;
        int case2_target = 0;
        int case3_target = 2;
        String message = "scope exception";

        //when
        final Throwable thrown1 = catchThrowable(() -> {
            NumberValidator.validateScope(case_min, case_max, case1_target, message);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            NumberValidator.validateScope(case_min, case_max, case2_target, message);
        });
        final Throwable thrown3 = catchThrowable(() -> {
            NumberValidator.validateScope(case_min, case_max, case3_target, message);
        });

        //then
        assertThat(thrown1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
        assertThat(thrown2)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
        assertThat(thrown3)
                .doesNotThrowAnyException();
    }
}
