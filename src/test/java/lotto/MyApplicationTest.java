package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;


class MyApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 당첨번호에_숫자_45초과_오류() {
        assertSimpleTest(() -> {
            runException("1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨번호에_알파벳_문자_존재_오류() {
        assertSimpleTest(() -> {
            runException("1,2,3,a,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스번호에_숫자_아닌_값_존재_오류() {
        assertSimpleTest(() -> {
            runException("b");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스번호에_숫자_45초과_오류() {
        assertSimpleTest(() -> {
            runException("46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
