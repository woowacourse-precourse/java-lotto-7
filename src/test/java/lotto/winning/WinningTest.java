package lotto.winning;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lotto.validate.WinningValidate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningTest {
    @Test
    @DisplayName("숫자와 쉼표로 이루어진 문자열은 올바른 당첨 번호 문자열이다.")
    public void testValidWinningString() {
        String winningString = "1,2,3,4,5,6";

        assertTrue(WinningValidate.isValidString(winningString));
    }

    @Test
    @DisplayName("숫자와 쉼표로 이루어지지 않은 문자열은 올바르지 않은 당첨 번호 문자열이다.")
    public void testInValidWinningString() {
        String winningString = "1,2, 3,4, ab,c!";

        assertFalse(WinningValidate.isValidString(winningString));
    }
}
