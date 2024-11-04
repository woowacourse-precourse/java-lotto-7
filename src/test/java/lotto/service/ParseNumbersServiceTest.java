package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static lotto.constants.ErrorMessage.INPUT_CAN_NOT_BE_BLANK;

import java.util.List;
import lotto.model.InputWinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParseNumbersServiceTest {

    @DisplayName("쉼표로 자른 후, 공백인 경우 예외가 발생한다.")
    @Test
    public void ThrowExceptionAfterParseIsBlank() {
        // given
        InputWinningNumbers inputWinningNumbers = new InputWinningNumbers("1,,2");
        ParseNumbersService parseNumbersService = new ParseNumbersService();

        // when
        Throwable thrown = catchThrowable(() -> {
            List<Integer> winningLotto = parseNumbersService.getWinningLotto(inputWinningNumbers);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_CAN_NOT_BE_BLANK.get());
    }


}
