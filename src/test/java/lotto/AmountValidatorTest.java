package lotto;

import lotto.validator.AmountValidator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AmountValidatorTest {
    AmountValidator amountValidator = new AmountValidator();


    @Test
    public void inputAmountValidationTest() throws Exception {
        Method method = AmountValidator.class.getDeclaredMethod("inputAmountValidation", String.class);
        method.setAccessible(true);

        assertTrue((Boolean) method.invoke(amountValidator, "8000"));
    }


    @Test
    public void isThousandUnitTest() throws Exception {

        Method method = AmountValidator.class.getDeclaredMethod("isThousandUnit", String.class);
        method.setAccessible(true);

        assertTrue((Boolean) method.invoke(amountValidator, "18000"));

        assertThatThrownBy(() -> {
            try {
                method.invoke(amountValidator, "123456");
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void isAmountUnderLimitTest() throws Exception {

        Method method = AmountValidator.class.getDeclaredMethod("isAmountUnderLimit", String.class);
        method.setAccessible(true);

        assertTrue((Boolean) method.invoke(amountValidator, "100000"));

        assertThatThrownBy(() -> {
            try {
                method.invoke(amountValidator, "200000");
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
