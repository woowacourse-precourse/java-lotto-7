package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 구입_금액_입력_테스트() {
        assertSimpleTest(() -> {
            runException("5555");  // 구입 금액에 유효하지 않은 값 입력
            assertThat(output()).contains(ERROR_MESSAGE);  // 출력에 [ERROR] 메시지가 포함되었는지 확인
        });
    }

    @Test
    void 당첨번호_잘못된_개수_입력_테스트() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5");  // 6개가 아닌 당첨 번호 입력
            assertThat(output()).contains(ERROR_MESSAGE);  // 출력에 [ERROR] 메시지가 포함되었는지 확인
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
