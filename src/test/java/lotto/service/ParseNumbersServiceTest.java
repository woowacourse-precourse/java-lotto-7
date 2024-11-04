package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static lotto.constants.ErrorMessage.INPUT_CAN_NOT_BE_BLANK;
import static lotto.constants.ErrorMessage.LOTTO_CAN_NOT_HAVE_CHARACTER;

import java.util.List;
import lotto.model.InputWinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("쉼표로 자른 후 문자가 포함되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,-1,3", "1,2.3,4", "1,a,b,c"})
    public void ThrowExceptionIfHasCharacter(String inputNumbers) {
        // given
        InputWinningNumbers inputWinningNumbers = new InputWinningNumbers(inputNumbers);
        ParseNumbersService parseNumbersService = new ParseNumbersService();

        // when
        Throwable thrown = catchThrowable(() -> {
            List<Integer> winningLotto = parseNumbersService.getWinningLotto(inputWinningNumbers);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_CAN_NOT_HAVE_CHARACTER.get());
    }
}
