package lotto;

import lotto.util.InputUtils;
import lotto.util.RegexUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UtilsTest {
    @Test
    public void inputUtilsTest() {
        String test = InputUtils.retryRequest("13",
                result -> {
                    return !result.isEmpty();
                });

        assertThat(test).isEqualTo("13");
    }

    @Test
    public void removeSpaceTest() {
        assertThat(RegexUtils.removeSpaces("Hello World")).isEqualTo("HelloWorld");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "-1"})
    public void isFloatTest(String input) {
        assertTrue(RegexUtils.isNumeric(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "1000"})
    public void isPositiveNumericTest(String input) {
        assertTrue(RegexUtils.isPositiveNumeric(input));
    }

}
