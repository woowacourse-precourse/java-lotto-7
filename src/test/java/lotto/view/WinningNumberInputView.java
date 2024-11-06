package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberInputView extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("당첨 번호가 범위를 벗어난 경우 예외가 발생한다.")
    void 당첨_번호가_범위를_벗어나면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,47,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    void 당첨_번호가_6개가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호에 중복된 수가 있다면 예외가 발생한다.")
    void 당첨_번호가_중복되면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,4,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호가 숫자가 아니라면 예외가 발생한다.")
    void 당첨_번호가_숫자가_아니라면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,우테코,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
