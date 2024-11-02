package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;
import lotto.domain.Lotto;
import lotto.exception.ExceptionMessage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @Test
    void inputToParsed_정수입력() {
        String input = "1000";
        setInputStream(input);

        InputView inputView = new InputView();
        int result = inputView.inputToParsed();

        assertThat(result).isEqualTo(1000);
    }

    @Test
    void setWinningNumber_예외발생() {
        String input = "1, 2, 3, 4, 5, 5";
        setInputStream(input);

        InputView inputView = new InputView();

        assertThatThrownBy(inputView::setWinningNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_DUPLICATE_NUMBER.getMessage());
    }

    @Test
    void setWinningNumber_정상입력() {
        String input = "1, 2, 3, 4, 5, 6";
        setInputStream(input);

        InputView inputView = new InputView();
        Lotto lotto = inputView.setWinningNumber();

        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    private void setInputStream(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Console.close();
    }
}
