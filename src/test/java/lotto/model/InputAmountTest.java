package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.params.provider.ValueSource;

public class InputAmountTest {

    private InputAmount inputAmount;

    @DisplayName("입력값이 빈 값이면 예외를 발생시킨다.")
    @ParameterizedTest
    @NullAndEmptySource
    public void ThrowExceptionIfInputAmountBlank(String inputAmount) {
        Throwable thrown = catchThrowable(() -> {
            this.inputAmount = new InputAmount(inputAmount);
        });

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_CAN_NOT_BE_BLANK.get());
    }


}
