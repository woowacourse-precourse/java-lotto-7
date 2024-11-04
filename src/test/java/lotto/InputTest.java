package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("숫자가 큰 보너스 번호인 경우 예외가 발생한다.")
    @Test
    void 숫자가_큰_보너스번호() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "100");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("숫자가 아닌 보너스 번호인 경우 예외가 발생한다.")
    @Test
    void 숫자가_아닌_보너스번호() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "kk");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("음수인 보너스 번호인 경우 예외가 발생한다.")
    @Test
    void 음수인_보너스번호() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "-10");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("숫자가 아닌 로또 번호인 경우 예외가 발생한다.")
    @Test
    void 숫자가_아닌_로또번호() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,k", "10");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 번호와 보너스 번호가 중복인 경우 예외가 발생한다.")
    @Test
    void 보너스_번호와_로또_번호가_중복() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,10", "10");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("금액이 1000원으로 나누어떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void 금액이_1000으로_나누어떨어지지_않는_경우() {
        assertSimpleTest(() -> {
            runException("8100", "1,2,3,4,5,6", "10");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
