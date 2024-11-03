package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
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
    void PurchaseAmountIsNotNumber_Exception() {
        // given
        InputStream readLine = setReadLine("1000원");
        System.setIn(readLine);

        String expectedMessage = "[ERROR] 입력값은 숫자여야 합니다.";

        // when, then
        assertThatThrownBy(() -> InputView.inputLottoPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("구입 금액이 특정 값으로 나누어 떨어지지 않을 경우 IllegalArgumentExection을 발생시킨다.")
    void PurchaseAmountIsNotDivisible_Exception() {
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
    void PurchaseAmountIsZero_Exception() {
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
    void PurchaseAmountIsNegative_Exception() {
        // given
        InputStream readLine = setReadLine("-1000");
        System.setIn(readLine);

        String expectedMessage = "[ERROR] 구입금액은 양수여야 합니다.";

        // when, then
        assertThatThrownBy(() -> InputView.inputLottoPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("당첨 번호가 중복될 경우 IllegalArgumentExection을 발생시킨다.")
    void WinningNumbersIsDuplicated_Exception() {
        // given
        InputStream readLine = setReadLine("1,2,3,4,5,1");
        System.setIn(readLine);

        String expectedMessage = "[ERROR] 로또 번호는 중복될 수 없습니다.";

        // when, then
        assertThatThrownBy(() -> InputView.inputLottoWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닐 경우 IllegalArgumentExection을 발생시킨다.")
    void WinningNumbersCountIsNotSix_Exception() {
        // given
        InputStream readLine = setReadLine("1,2,3,4,5");
        System.setIn(readLine);

        String expectedMessage = "[ERROR] 로또 번호는 6개여야 합니다.";

        // when, then
        assertThatThrownBy(() -> InputView.inputLottoWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("당첨 번호가 범위에서 벗어낫을 경우 IllegalArgumentExection을 발생시킨다.")
    void WinningNumbersIsNotInRange_Exception() {
        // given
        InputStream readLine = setReadLine("1,2,3,4,5,50");
        System.setIn(readLine);

        String expectedMessage = "[ERROR] 로또 번호가 범위에서 벗어났습니다.";

        // when, then
        assertThatThrownBy(() -> InputView.inputLottoWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("당첨 번호가 숫자가 아닐 경우 IllegalArgumentExection을 발생시킨다.")
    void WinningNumbersIsNotNumber_Exception() {
        // given
        InputStream readLine = setReadLine("1,2,3,4,5,육");
        System.setIn(readLine);

        String expectedMessage = "[ERROR] 당첨 번호는 숫자여야 합니다.";

        // when, then
        assertThatThrownBy(() -> InputView.inputLottoWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("당첨 번호가 올바를 경우 Success")
    void WinningNumbers_Success() {
        // given
        InputStream readLine = setReadLine("1,2,3,4,5,6");
        System.setIn(readLine);

        // when
        List<Integer> result = InputView.inputLottoWinningNumbers().getNumbers();

        // then
        assertThat(result).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닐 경우 IllegalException")
    void BounusNumberIsNotNumber_Exception() {
        // given
        InputStream readLine = setReadLine("육");
        System.setIn(readLine);

        String expectedMessage = "[ERROR] 입력값은 숫자여야 합니다.";

        // when, then
        assertThatThrownBy(() -> InputView.inputBonusNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }



    static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }
}
