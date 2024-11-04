package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 숫자가_큰_보너스번호() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "100");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 숫자가_아닌_보너스번호() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "kk");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 음수인_보너스번호() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "-10");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 숫자가_아닌_로또번호() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,k", "10");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
