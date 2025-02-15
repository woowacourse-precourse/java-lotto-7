package lotto;

import lotto.validator.BonusNumber;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BonusNumberTest {

    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    BonusNumber bonus = new BonusNumber(numbers);


    @Test
    public void bonusNumberValidateTest() throws Exception {
        Method method = BonusNumber.class.getDeclaredMethod("validate", String.class);
        method.setAccessible(true);

        assertTrue((Boolean) method.invoke(bonus, "23"));

        assertThatThrownBy(() -> {
            try {
                method.invoke(bonus, "200");
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }).isInstanceOf(IllegalArgumentException.class);

    }

}