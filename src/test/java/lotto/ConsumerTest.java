package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.Exception.DONT_NOT_ZERO;
import static lotto.Exception.IS_NOT_1000_UNIT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ConsumerTest extends NsTest {
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1001"})
    void 구입금액_천원단위_테스트(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IS_NOT_1000_UNIT)
        );
    }

    @Test
    void 구입금액_0원_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(DONT_NOT_ZERO)
        );
    }
}
