package lotto;

import lotto.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {

    Validator validator = new Validator() {
        @Override
        protected Boolean validate(String request) {
            return true;
        }
    };

    @DisplayName("콘솔에서 들어 올떄 먼저 trim()을 하기때문데 공백도 빈값이 아니여야 한다")
    @ParameterizedTest
    @ValueSource(strings = {" ", "   ", "        "})
    public void nonEmptyTest(String input) {
        assertTrue((validator.nonEmpty("", input)));

        assertThatThrownBy(() -> validator.nonEmpty("", input.trim())).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "-1"})
    public void isNumberTest(String input) {
        assertTrue(validator.isNumeric("", input));
    }

    @Test
    public void isNumericTest_Exception() {
        assertThatThrownBy(
                () -> validator.isNumeric("", "1.2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void isPositiveTest() {
        assertThatThrownBy(
                () -> validator.isPositiveNumeric("", "-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void hasNoDuplicatesTest() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3));

        assertThatThrownBy(
                () -> validator.hasNoDuplicates("", numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46, 9900})
    public void isLottoNumberRangeTest(int input) {
        assertThatThrownBy(
                () -> validator.isLottoNumberRange("", input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
