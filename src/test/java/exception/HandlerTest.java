package exception;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class HandlerTest extends NsTest{
    @DisplayName("로또 구입 개수")
    @Test
    void 로또_구입_개수() {
        assertSimpleTest(() -> {
            run("1000"); // 왜 입력값이 1로 되는지...

            int result = exception.Handler.getLottoNumber();
            assertThat(result).isEqualTo(1);
        });

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

