package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class PurchaseAmountTest extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("금액이 1,000원으로 나누어 떨어지지 않는 경우 예외 발생")
    void 구매_금액이_1000원으로_나누어_떨어지지_않으면_예외_발생() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("금액이 정수가 아닌 경우 예외 발생")
    void 구매_금액이_정수가_아닌_경우_예외_발생() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("금액이 음수인 경우 예외 발생")
    void 구매_금액이_음수인_경우_예외_발생() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("금액이 0인 경우 예외 발생")
    void 구매_금액이_0인_경우_예외_발생() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("금액이 비어있는 경우 예외 발생")
    void 구매_금액이_비어있는_경우_예외_발생() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
