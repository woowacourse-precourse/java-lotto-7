package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.params.provider.ValueSource;

public class InputAmountTest {

    private InputAmount inputAmount;

    @DisplayName("입력값이 빈 값이면 예외를 발생시킨다.")
    @ParameterizedTest
    @NullAndEmptySource // given
    public void ThrowExceptionIfInputAmountBlank(String inputAmount) {
        // when
        Throwable thrown = catchThrowable(() -> {
            this.inputAmount = new InputAmount(inputAmount);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_CAN_NOT_BE_BLANK.get());
    }

    @DisplayName("숫자 이외의 문자를 포함하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,000", "abc", "한글"}) // given
    public void ThrowExceptionIfInputAmountHasCharacter(String inputAmount) {
        // when
        Throwable thrown = catchThrowable(() -> {
            this.inputAmount = new InputAmount(inputAmount);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.AMOUNT_CAN_NOT_HAVE_CHARACTER.get());
    }

    @DisplayName("구매 금액이 0이면 예외를 발생시킨다.")
    @Test
    public void ThrowExceptionIfInputAmountZero() {
        // given
        String zeroAmount = "0";

        // when
        Throwable thrown = catchThrowable(() -> {
            this.inputAmount = new InputAmount(zeroAmount);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.AMOUNT_CAN_NOT_BE_ZERO.get());
    }
}
