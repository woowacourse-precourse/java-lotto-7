package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class WinningTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 당첨_번호_숫자외의_문자_입력시_예외처리() {
        assertSimpleTest(() -> {
            runException("1000", "a,b,c,d,e,f,g");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨_번호_1에서_45사이의_숫자_입력하지_않았을시_예외처리1() {
        assertSimpleTest(() -> {
            runException("1000", "0,1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨_번호_1에서_45사이의_숫자_입력하지_않았을시_예외처리2() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨_번호_6개의_숫자_입력하지_않았을시_예외처리1() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨_번호_6개의_숫자_입력하지_않았을시_예외처리2() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨_번호_중복_되었을시_예외처리() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
