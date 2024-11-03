package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class AmountTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";


    @Test
    void 로또_구입_금액_숫자외의_문자입력시_예외발생() {
        assertSimpleTest(() -> {
            runException("abc");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 로또_구입_금액_1000원_단위_아닐시_예외발생() {
        assertSimpleTest(() -> {
            runException("3500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 로또_구입_금액_1000원_미만일시_예외발생() {
        assertSimpleTest(() -> {
            runException("500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
