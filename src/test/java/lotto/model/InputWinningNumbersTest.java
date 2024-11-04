package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static lotto.constants.ErrorMessage.INPUT_CAN_NOT_BE_BLANK;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class InputWinningNumbersTest {

    @DisplayName("빈 값을 입력받는 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @NullAndEmptySource // given
    public void ThrowExceptionIfWinningNumbersBlank(String winningNumbers) {
        // when
        Throwable thrown = catchThrowable(() -> {
            InputWinningNumbers inputWinningNumbers = new InputWinningNumbers(winningNumbers);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_CAN_NOT_BE_BLANK.get());
    }
}
