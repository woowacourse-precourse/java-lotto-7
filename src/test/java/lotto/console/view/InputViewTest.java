package lotto.console.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @DisplayName("성공 | 금액 입력이 정상적으로 이루어진 경우")
    @ParameterizedTest
    @ValueSource(strings = {"0", "10", "1234", "1000", "11000", "2000", "21000"})
    void should_ReadMoney_When_InputIsValid(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();

        int money = inputView.readMoney();
        assertThat(money).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("예외 | 금액 입력이 정상적으로 이루어지지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "a", "1.1", "1,000"})
    void should_ThrowException_When_InputIsInvalid(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();

        assertThatThrownBy(inputView::readMoney)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("성공 | 당첨 번호 입력이 정상적으로 이루어진 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "10,20,30,40,41,42", "3,21,7,41,33,42", "10,20,30,40,50,60"})
    void should_ReadWinNumbers_When_InputIsValid(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        List<Integer> winNumbers = inputView.readWinNumbers();

        List<Integer> expected = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
        assertThat(winNumbers).isEqualTo(expected);
    }
}
