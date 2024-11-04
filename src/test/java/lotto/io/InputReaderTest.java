package lotto.io;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class InputReaderTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    @Test
    @DisplayName("구입금액 입력값 테스트")
    void 구입금액_입력값_테스트() {
        assertSimpleTest(() -> {
            runException("2147483678");
            assertThat(output()).contains(
                    ERROR_MESSAGE + "구매할 수 있는 최대 금액을 초과했습니다.");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}