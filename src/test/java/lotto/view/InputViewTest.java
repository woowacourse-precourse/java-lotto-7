package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("구입 금액이 숫자가 아닌 경우 IllegalArgumentExection을 발생시킨다.")
    void inputIsNotNumber_Exception() {
        // given
        InputStream readLine = setReadLine("1000원");
        System.setIn(readLine);

        String expectedMessage = "[ERROR] 구입금액은 숫자여야 합니다.";

        // when, then
        assertThatThrownBy(() -> InputView.inputLottoPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("구입 금액이 특정 값으로 나누어 떨어지지 않을 경우 IllegalArgumentExection을 발생시킨다.")
    void inputIsNotDivisible_Exception() {
        // given
        InputStream readLine = setReadLine("1500");
        System.setIn(readLine);

        String expectedMessage = "[ERROR] 구입금액은 1000원으로 나누어 떨어져야 합니다.";

        // when, then
        assertThatThrownBy(() -> InputView.inputLottoPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("구입 금액이 0일 경우 IllegalArgumentExection을 발생시킨다.")
    void inputIsZero_Exception() {
        // given
        InputStream readLine = setReadLine("0");
        System.setIn(readLine);

        String expectedMessage = "[ERROR] 구입금액은 양수여야 합니다.";

        // when, then
        assertThatThrownBy(() -> InputView.inputLottoPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("구입 금액이 0일 경우 IllegalArgumentExection을 발생시킨다.")
    void inputIsNegative_Exception() {
        // given
        InputStream readLine = setReadLine("-1000");
        System.setIn(readLine);

        String expectedMessage = "[ERROR] 구입금액은 양수여야 합니다.";

        // when, then
        assertThatThrownBy(() -> InputView.inputLottoPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }
}
