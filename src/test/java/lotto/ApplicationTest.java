package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 정상입력_테스트() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(
                    "구입금액을 입력해주세요.",
                    "8개를 구매했습니다.",
                    "당첨 번호를 입력해 주세요.",
                    "보너스 번호를 입력해 주세요."
            );
        });
    }

    @Test
    void 구매금액_예외_테스트_1() {
        assertSimpleTest(() -> {
            runException("팔천원"); // 문자열 입력 시 예외 발생
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ERROR] 유효한 숫자를 입력하세요."
            );
        });
    }

    @Test
    void 구매금액_예외_테스트_2() {
        assertSimpleTest(() -> {
            runException("8001"); // 1,000원 단위가 아닌 금액 입력 시 예외 발생
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ERROR] 1,000원 단위로 입력하세요."
            );
        });
    }

    @Test
    void 당첨번호_예외_테스트_1() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,six"); // 당첨 번호에 유효하지 않은 입력 시 예외 발생
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ERROR] 유효한 숫자를 입력하세요."
            );
        });
    }

    @Test
    void 당첨번호_예외_테스트_2() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6,7"); // 6개 초과 입력 시 예외 발생
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ERROR] 로또 번호는 6개여야 합니다."
            );
        });
    }

    @Test
    void 당첨번호_예외_테스트_3() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,4,5"); // 중복 번호 입력 시 예외 발생
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ERROR] 중복되지 않는 번호를 입력하세요."
            );
        });
    }

    @Test
    void 당첨번호_예외_테스트_4() {
        assertSimpleTest(() -> {
            run("8000", "0,1,2,3,4,5"); // 1~45 범위를 벗어난 번호 입력 시 예외 발생
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ERROR] 1부터 45 사이의 숫자를 입력하세요."
            );
        });
    }

    @Test
    void 보너스번호_중복입력_예외_테스트_1() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "0"); // 보너스 번호가 범위를 벗어날 시 예외 발생
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ERROR] 1부터 45 사이의 숫자를 입력하세요."
            );
        });
    }

    @Test
    void 보너스번호_중복입력_예외_테스트_2() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "6"); // 보너스 번호가 당첨 번호와 중복될 시 예외 발생
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."
            );
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
