package lotto.util;

import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RetryUtilTest {

    private static final String ERROR_PREFIX = "[ERROR]";

    @Test
    @DisplayName("올바른 구매 금액을 입력하면 해당 값을 반환한다")
    void retryReadPurchaseAmount_ValidInput_ReturnsValue() {
        String result = RetryUtil.retryReadPurchaseAmount(() -> "8000");
        assertThat(result).isEqualTo("8000");
    }

    @Test
    @DisplayName("잘못된 구매 금액을 입력하면 에러 메시지를 출력하고 재시도한다")
    void retryReadPurchaseAmount_InvalidInput_RetryUntilValid() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String result = RetryUtil.retryReadPurchaseAmount(new InvalidThenValidSupplier("abc", "8000"));

        assertThat(result).isEqualTo("8000");
        assertThat(outputStream.toString()).contains(ERROR_PREFIX);
    }

    @Test
    @DisplayName("올바른 당첨 번호를 입력하면 해당 값을 반환한다")
    void retryReadWinningNumber_ValidInput_ReturnsValue() {
        String result = RetryUtil.retryReadWinningNumber(() -> "1,2,3,4,5,6");
        assertThat(result).isEqualTo("1,2,3,4,5,6");
    }

    @Test
    @DisplayName("잘못된 당첨 번호를 입력하면 에러 메시지를 출력하고 재시도한다")
    void retryReadWinningNumber_InvalidInput_RetryUntilValid() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String result = RetryUtil.retryReadWinningNumber(
                new InvalidThenValidSupplier("1,2,3", "1,2,3,4,5,6")
        );

        assertThat(result).isEqualTo("1,2,3,4,5,6");
        assertThat(outputStream.toString()).contains(ERROR_PREFIX);
    }

    @Test
    @DisplayName("올바른 보너스 번호를 입력하면 해당 값을 반환한다")
    void retryReadBonusNumber_ValidInput_ReturnsValue() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        String result = RetryUtil.retryReadBonusNumber(() -> "7", winningNumbers);
        assertThat(result).isEqualTo("7");
    }

    @Test
    @DisplayName("잘못된 보너스 번호를 입력하면 에러 메시지를 출력하고 재시도한다")
    void retryReadBonusNumber_InvalidInput_RetryUntilValid() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        String result = RetryUtil.retryReadBonusNumber(
                new InvalidThenValidSupplier("1", "7"),
                winningNumbers
        );

        assertThat(result).isEqualTo("7");
        assertThat(outputStream.toString()).contains(ERROR_PREFIX);
    }

    private static class InvalidThenValidSupplier implements Supplier<String> {
        private final String invalidInput;
        private final String validInput;
        private boolean firstCall = true;

        InvalidThenValidSupplier(String invalidInput, String validInput) {
            this.invalidInput = invalidInput;
            this.validInput = validInput;
        }

        @Override
        public String get() {
            if (firstCall) {
                firstCall = false;
                return invalidInput;
            }
            return validInput;
        }
    }
}
