package lotto;

import lotto.validator.WinningNumbersValidator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinningNumbersValidatorTest {
    WinningNumbersValidator winningNumbers = new WinningNumbersValidator();


    @Test
    public void winningNumbersValidationTest() throws Exception {
        Method method = WinningNumbersValidator.class.getDeclaredMethod("winningNumbersValidation", String.class);
        method.setAccessible(true);

        assertTrue((Boolean) method.invoke(winningNumbers, "1,3,4"));
    }


    @Test
    public void isRegexCheckTest() throws Exception {

        Method method = WinningNumbersValidator.class.getDeclaredMethod("isRegexCheck", String.class);
        method.setAccessible(true);

        assertTrue((Boolean) method.invoke(winningNumbers, "1,2,3,4,5,6"));

        assertThatThrownBy(() -> {
            try {
                method.invoke(winningNumbers, "1;2;3;");
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void isSixWinningNumbersTest() throws Exception {
        Method method = WinningNumbersValidator.class.getDeclaredMethod("isSixWinningNumbers", List.class);
        method.setAccessible(true);

        String[] sixCount = {"1", "2", "3", "4", "5", "6"};
        String[] fourCount = {"1", "2", "3", "4"};


        assertTrue((Boolean) method.invoke(winningNumbers, new LinkedList<>(Arrays.asList(sixCount))));

        assertThatThrownBy(() -> {
            try {
                method.invoke(winningNumbers, new LinkedList<>(Arrays.asList(fourCount)));
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void isLottoNumberRangeTest() throws Exception {
        Method method = WinningNumbersValidator.class.getDeclaredMethod("isLottoNumberRange", List.class);
        method.setAccessible(true);

        String[] sixCount = {"1", "2", "3", "4", "5", "6"};
        String[] overNumber = {"1", "2", "3", "4", "46", "47"};

        assertTrue((Boolean) method.invoke(winningNumbers, new LinkedList<>(Arrays.asList(sixCount))));

        assertThatThrownBy(() -> {
            try {
                method.invoke(winningNumbers, new LinkedList<>(Arrays.asList(overNumber)));
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
