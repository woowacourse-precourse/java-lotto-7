package lotto;

import lotto.validator.LuckyNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LuckyNumbersTest {
    LuckyNumbers luckyNumbers = new LuckyNumbers();


    @Test
    public void luckyNumbersNumbersValidateTest() throws Exception {
        Method method = LuckyNumbers.class.getDeclaredMethod("validate", String.class);
        method.setAccessible(true);

        assertTrue((Boolean) method.invoke(luckyNumbers, "1,3,4,5,6,7"));
    }

    @DisplayName("중복이 있으면 예외")
    @Test
    public void luckyNumbersValidateTest_Exception() throws Exception {
        Method method = LuckyNumbers.class.getDeclaredMethod("validate", String.class);
        method.setAccessible(true);

        assertThatThrownBy(
                () -> method.invoke(luckyNumbers, "1,3,3,4,4,5"))
                .isInstanceOf(InvocationTargetException.class);
    }


    @Test
    public void isRegexCheckTest() throws Exception {

        Method method = LuckyNumbers.class.getDeclaredMethod("isRegexCheck", String.class);
        method.setAccessible(true);

        assertTrue((Boolean) method.invoke(luckyNumbers, "1,2,3,4,5,6"));

        assertThatThrownBy(() -> {
            try {
                method.invoke(luckyNumbers, "1;2;3;");
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
