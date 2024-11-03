package lotto.domain;

import lotto.exception.InputErrorMessage;
import lotto.model.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningNumbersTest {

    @Test
    void 당첨번호가_비어있을_경우_예외발생() {
        assertThatThrownBy(() -> new WinningNumbers(Arrays.asList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.EMPTY_INPUT.getMessage());
    }

    @Test
    void 당첨번호가_null일_경우_예외발생() {
        assertThatThrownBy(() -> new WinningNumbers(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.EMPTY_INPUT.getMessage());
    }

    @Test
    void 당첨번호가_6개가_아닐_경우_예외발생() {
        assertThatThrownBy(() -> new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.OVER_SIZE_WINNING_NUMBER.getMessage());
    }

    @Test
    void 당첨번호가_중복될_경우_예외발생() {
        assertThatThrownBy(() -> new WinningNumbers(Arrays.asList(1, 2, 3, 4, 4, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.DUPLICATED_WINNING_NUMBER.getMessage());
    }

    @Test
    void 당첨번호가_정상일_경우_정상적으로_생성() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), winningNumbers.getWinningNumbers());
    }

}
