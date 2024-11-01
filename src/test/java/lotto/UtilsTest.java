package lotto;

import lotto.util.InputUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class UtilsTest {
    @Test
    public void inputUtilsTest() {
        String test = InputUtils.retryRequest("13",
                result -> {
                    return !result.isEmpty();
                });

        assertThat(test).isEqualTo("13");
    }

}
