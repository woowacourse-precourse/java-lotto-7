package lotto.utils;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsTest {

    @DisplayName("문자열이 숫자로 구성되었는지 확인한다")
    @Test
    void isDigitOnly() {
        assertTrue(Utils.isDigitOnly("123123"));
        assertTrue(Utils.isDigitOnly("1"));
        assertTrue(Utils.isDigitOnly("2147483647"));
    }
}