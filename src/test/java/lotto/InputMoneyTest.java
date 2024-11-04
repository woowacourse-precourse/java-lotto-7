package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputMoneyTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("구입 금액이 숫자가 아님")
    void test1() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
