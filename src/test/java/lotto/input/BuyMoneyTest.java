package lotto.input;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyMoneyTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("구매_금액으로_문자를_입력할_수_없다")
    @Test
    void 구매_금액으로_문자를_입력할_수_없다() {
        assertSimpleTest(() -> {
            runException("a", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구매_금액으로_공백을_입력할_수_없다")
    @Test
    void 구매_금액으로_공백을_입력할_수_없다() {
        assertSimpleTest(() -> {
            runException(" ", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구매_금액이_천원단위가_아니면_안된다")
    @Test
    void 구매_금액이_천원단위가_아니면_안된다() {
        assertSimpleTest(() -> {
            runException("100", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}