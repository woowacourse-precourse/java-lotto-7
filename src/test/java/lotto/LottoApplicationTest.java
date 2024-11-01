package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class LottoApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 문자_포함_구매금액_입력시_예외_메시지_출력() {
        assertSimpleTest(() -> {
            runException("1000.0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 정수_형태_아닌_구매금액_입력시_예외_메시지_출력() {
        assertSimpleTest(() -> {
            runException("1234312432154325435");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구매금액_0원_입력시_예외_메시지_출력() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구매금액_1000원단위_아닐시_예외_메시지_출력() {
        assertSimpleTest(() -> {
            runException("1200");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}