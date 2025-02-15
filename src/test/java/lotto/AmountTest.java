package lotto;

import lotto.validator.Amount;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AmountTest {
    Amount amount = new Amount();


    @Test
    public void amountValidateTest() throws Exception {
        Method method = Amount.class.getDeclaredMethod("validate", String.class);
        method.setAccessible(true);

        assertTrue((Boolean) method.invoke(amount, "8000"));
    }


    @Test
    public void isThousandUnitTest() throws Exception {

        Method method = Amount.class.getDeclaredMethod("isThousandUnit", String.class);
        method.setAccessible(true);

        assertTrue((Boolean) method.invoke(amount, "18000"));

        assertThatThrownBy(() -> {
            try {
                method.invoke(amount, "123456");
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void isAmountUnderLimitTest() throws Exception {

        Method method = Amount.class.getDeclaredMethod("isAmountUnderLimit", String.class);
        method.setAccessible(true);

        assertTrue((Boolean) method.invoke(amount, "100000"));

        assertThatThrownBy(() -> {
            try {
                method.invoke(amount, "200000");
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
