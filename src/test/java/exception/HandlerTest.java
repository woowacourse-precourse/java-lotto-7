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
            run("1000","1,2,3,4,5,6","7");

            assertThat(output()).contains(
                    "1개를 구매했습니다.");
        });

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

