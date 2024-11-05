package lotto.valuate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberValuateTest {

    @Test
    void isValidNumber_validNumber_doesNotThrowException() {
        String validInput = "5";
        assertDoesNotThrow(() -> BonusNumberValidate.isValidNumber(validInput),
                "정상값을 예외로 던지고 있습니다.");
    }

    @Test
    void isValidNumber_invalidNumber_throwsException() {
        String invalidInput = "abc";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> BonusNumberValidate.isValidNumber(invalidInput),
                "Invalid input should throw an IllegalArgumentException.");

        assertEquals("보너스 번호는 한개의 숫자만 허용됩니다. ex) 5", exception.getMessage());
    }
}
