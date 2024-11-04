package lotto.valuate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WinnerNumberValidateTest {

    @Test
    void isValidNumber_validNumber_doesNotThrowException() {
        String validInput = "15";

        assertDoesNotThrow(() -> WinnerNumberValidate.isValidNumber(validInput),
                "정상적인 입력값이 에러를 발생시키고 있습니다.");
    }

    @Test
    void isValidNumber_blankInput_throwsException() {
        String blankInput = "";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> WinnerNumberValidate.isValidNumber(blankInput),
                "공백은 IllegalArgumentException 에러를 발생시켜야 합니다.");

        assertEquals("당첨 번호에 공백을 포함할 수 없습니다.", exception.getMessage());
    }

    @Test
    void isValidNumber_nonNumericInput_throwsException() {
        String nonNumericInput = "abc";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> WinnerNumberValidate.isValidNumber(nonNumericInput),
                "숫자가 아니면 에러를 발생시켜야 합니다.");

        assertEquals("당첨 번호는 숫자만 입력할 수 있습니다.", exception.getMessage());
    }
}
