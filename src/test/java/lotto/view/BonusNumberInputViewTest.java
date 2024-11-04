package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberInputViewTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("보너스 번호가 범위를 벗어난 경우 예외가 발생한다.")
    void 보너스_번호가_범위를_벗어나면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 번호가 1개 초과로 입력받으면 예외가 발생한다.")
    void 보너스_번호가_1개_초과로_입력되면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "7,8");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아니라면 예외가 발생한다.")
    void 보너스_번호가_숫자가_아니라면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "우테코");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
