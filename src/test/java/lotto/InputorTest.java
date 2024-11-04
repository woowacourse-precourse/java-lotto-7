package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputorTest extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR]";


    @DisplayName("구입 금액이 음수면 예외가 발생한다.")
    @Test
    void 구입_금액이_음수면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("-1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구입 금액이 1000 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000_단위가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("955");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구입 금액이 정수가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000_정수가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1.1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


    public void runMain() {
        Application.main(new String[]{});
    }

}
