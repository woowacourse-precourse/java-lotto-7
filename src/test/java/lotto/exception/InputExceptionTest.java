import lotto.exception.InputException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InputExceptionTest {

    private final InputException inputException = new InputException();

    @Test
    void validateInputEmpty_빈입력일때_예외발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputException.validateInputEmpty("");
        });
        assertEquals("[ERROR] 입력이 되지 않았습니다", exception.getMessage());
    }

    @Test
    void validateDivisibleByTicketPrice_구매금액이_단위금액으로_나누어떨어지지않으면_예외발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputException.validateDivisibleByTicketPrice(2500, 1000);
        });
        assertEquals("[ERROR] 로또 가격 단위는 1000원 입니다", exception.getMessage());
    }

    @Test
    void validateDivisibleByTicketPrice_구매금액이_단위금액으로_나누어떨어지면_예외없음() {
        assertDoesNotThrow(() -> {
            inputException.validateDivisibleByTicketPrice(3000, 1000);
        });
    }

    @Test
    void validateNumericInput_숫자가아닐때_예외발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputException.validateNumericInput("abc");
        });
        assertEquals("[ERROR] 숫자로 입력해주세요", exception.getMessage());
    }

    @Test
    void validateNumericInput_숫자일때_예외없음() {
        assertDoesNotThrow(() -> {
            inputException.validateNumericInput("123");
        });
    }

    @Test
    void validateValueInRange_범위를벗어나면_예외발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputException.validateValueInRange(50);
        });
        assertEquals("[ERROR] 로또 번호는 1부터 45까지입니다", exception.getMessage());
    }

    @Test
    void validateValueInRange_범위안에있으면_예외없음() {
        assertDoesNotThrow(() -> {
            inputException.validateValueInRange(10);
        });
    }

    @Test
    void validateSizeOfWinningNumbers_당첨번호가_여섯개가아니면_예외발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputException.validateSizeOfWinningNumbers(Arrays.asList(1, 2, 3));
        });
        assertEquals("[ERROR] 당첨 번호는 6개여야 합니다.", exception.getMessage());
    }

    @Test
    void validateSizeOfWinningNumbers_당첨번호가_여섯개이면_예외없음() {
        assertDoesNotThrow(() -> {
            inputException.validateSizeOfWinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        });
    }

    @Test
    void validateDuplicatedFromOriginNumber_보너스번호가_중복되면_예외발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputException.validateDuplicatedFromOriginNumber(5, Arrays.asList(1, 2, 3, 4, 5));
        });
        assertEquals("[ERROR] 보너스 번호는 일반 번호와 중복이 되면 안됩니다", exception.getMessage());
    }

    @Test
    void validateDuplicatedFromOriginNumber_보너스번호가_중복되지않으면_예외없음() {
        assertDoesNotThrow(() -> {
            inputException.validateDuplicatedFromOriginNumber(6, Arrays.asList(1, 2, 3, 4, 5));
        });
    }
}
