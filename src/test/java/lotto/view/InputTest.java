package lotto.view;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {
    private InputUtil input;

    @BeforeEach
    public void setUp(){
        input = new InputUtil();
    }

    @Test
    @DisplayName("정수가 아닌 수를 입력했을 때")
    public void getPurchaseAmount_nonNumericThenValid() throws Exception {
        String inValidInput = "1000.123";
        Method method = InputUtil.class.getDeclaredMethod("checkValidPurchaseAmount", String.class);
        method.setAccessible(true);
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, inValidInput);
        });
    }

    @Test
    @DisplayName("1,000원 미만 입력했을 때")
    public void getPurchaseAmount_lessThan1000() throws Exception {
        String inValidInput = "500";
        Method method = InputUtil.class.getDeclaredMethod("checkValidPurchaseAmount", String.class);
        method.setAccessible(true);
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, inValidInput);
        });
    }

    @Test
    @DisplayName("1,000원 단위가 아닌 숫자 입력했을 때")
    void getPurchaseAmount_notMultipleOf1000() throws Exception {
        String inValidInput = "1500";
        Method method = InputUtil.class.getDeclaredMethod("checkValidPurchaseAmount", String.class);
        method.setAccessible(true);
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, inValidInput);
        });
    }
}
