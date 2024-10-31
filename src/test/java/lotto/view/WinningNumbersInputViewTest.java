package lotto.view;

import static lotto.ExceptionMessage.BONUS_NUMBER_NOT_NUMERIC_EXCEPTION;
import static lotto.ExceptionMessage.WINNING_NUMBERS_NOT_NUMERIC_EXCEPTION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningNumbersInputViewTest {
    WinningNumbersInputView winningNumbersInputView;

    @BeforeEach
    void init() {
        winningNumbersInputView = new WinningNumbersInputView();
    }

    @AfterEach
    void after() {
        Console.close();
    }

    @Test
    void 당첨_번호를_쉼표를_기준으로_파싱한다() {
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThat(winningNumbersInputView.getWinningNumbers())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 당첨_번호가_숫자로만_이루어진_문자열이_아니라면_예외가_발생한다() {
        String input = "1,2,3,4,5,6번";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() ->
                winningNumbersInputView.getWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBERS_NOT_NUMERIC_EXCEPTION.message());
    }

    @Test
    void 보너스_번호가_숫자로만_이루어진_문자열이_아니라면_예외가_발생한다() {
        String input = "14번";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() ->
                winningNumbersInputView.getBonusNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_NOT_NUMERIC_EXCEPTION.message());
    }
}
