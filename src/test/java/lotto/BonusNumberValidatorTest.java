package lotto;

import lotto.validator.BonusNumberValidator;
import lotto.validator.WinningNumbersValidator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BonusNumberValidatorTest {
    BonusNumberValidator bonus = new BonusNumberValidator(new WinningNumbersValidator());


    @Test
    public void inputBonusValidationTest() throws Exception {
        Method method = BonusNumberValidator.class.getDeclaredMethod("inputBonusValidation", String.class);
        method.setAccessible(true);

        assertTrue((Boolean) method.invoke(bonus, "1"));
    }


    @Test
    public void isLottoNumberRangeTest() throws Exception {

        Method method = BonusNumberValidator.class.getDeclaredMethod("isLottoNumberRange", String.class);
        method.setAccessible(true);

        assertTrue((Boolean) method.invoke(bonus, "34"));

        assertThatThrownBy(() -> {
            try {
                method.invoke(bonus, "49");
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

}