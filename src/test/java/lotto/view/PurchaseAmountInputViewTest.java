package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountInputViewTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("구매금액이 0이하인 경우 예외가 발생한다.")
    void 구매금액이_0이하면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("-1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("구매금액이 숫자가 아닌 경우 예외가 발생한다.")
    void 구매금액이_숫자가_아니라면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("우테코");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("구매금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    void 구매금액이_1000원_단위가_아니라면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("300");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
