package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import org.junit.jupiter.api.Test;

class UserInputTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 유효한_구입금액_테스트() {
        assertSimpleTest(() -> {
            // 구입 금액, 당첨 번호, 보너스 번호를 차례로 전달합니다.
            run("8000", "1,2,3,4,5,6", "7");

            assertThat(output()).doesNotContain(ERROR_MESSAGE);
        });
    }

    @Test
    void 유효하지_않은_당첨번호_테스트() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,46", "7");
            assertThat(output()).contains(ERROR_MESSAGE)
                    .contains("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        });
    }

    @Test
    void 문자_입력시_테스트() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,e,4,5,45", "7");
            assertThat(output()).contains(ERROR_MESSAGE)
                    .contains("숫자만 입력해야 합니다.");
        });
    }

    @Test
    void 유효하지_않은_보너스번호_중복_테스트() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "6");  // 보너스 번호가 당첨 번호와 중복
            assertThat(output()).contains(ERROR_MESSAGE)
                    .contains("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}