package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

public class InputViewTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 지불_단위_예외_테스트() {
        assertSimpleTest(() -> {
            // when : 1,000 단위가 아닌 금액을 입력했을 때
            runException("550");

            // then : 예외 메시지가 출력되는지 확인
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 지불_범위_예외_테스트() {
        assertSimpleTest(() -> {
            // when : 음수 금액을 입력했을 때
            runException("-1000");

            // then : 예외 메시지가 출력되는지 확인
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨_번호_형식_예외_테스트() {
        assertSimpleTest(() -> {
            // when : 형식에 맞지 않는 당첨 번호를 입력했을 때
            runException("8000", "일,이,삼,사,오,육");

            // then : 예외 메시지가 출력되는지 확인
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨_번호_갯수_초과_예외_테스트() {
        assertSimpleTest(() -> {
            // when : 당첨 번호 갯수를 초과하여 입력했을 때
            runException("8000", "1,2,3,4,5,6,7,8,9,10,11,12");

            // then : 예외 메시지가 출력되는지 확인
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨_번호_갯수_미달_예외_테스트() {
        assertSimpleTest(() -> {
            // when : 당첨 번호 갯수를 미달하여 입력했을 때
            runException("8000", "1,2,3,4,5");

            // then : 예외 메시지가 출력되는지 확인
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨_번호_중복_예외_테스트() {
        assertSimpleTest(() -> {
            // when : 중복된 당첨 번호를 입력했을 때
            runException("8000", "1,2,3,3,5,6", "7");

            // then : 예외 메시지가 출력되는지 확인
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨_번호_범위_예외_테스트() {
        assertSimpleTest(() -> {
            // when : 범위를 초과한 당첨 번호를 입력했을 때
            runException("8000", "0,2,3,4,5,6", "7");

            // then : 예외 메시지가 출력되는지 확인
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스_번호_범위_예외_테스트() {
        assertSimpleTest(() -> {
            // when : 범위를 초과한 보너스 번호를 입력했을 때
            runException("8000", "1,2,3,4,5,6", "46");

            // then : 예외 메시지가 출력되는지 확인
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스_번호_형식_예외_테스트() {
        assertSimpleTest(() -> {
            // when : 형식에 맞지 않는 보너스 번호를 입력했을 때
            runException("8000", "1,2,3,4,5,6", "칠");

            // then : 예외 메시지가 출력되는지 확인
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스_번호_중복_예외_테스트() {
        assertSimpleTest(() -> {
            // when : 당첨 번호에 포함된 보너스 번호를 입력했을 때
            runException("8000", "1,2,3,4,5,6", "6");

            // then : 예외 메시지가 출력되는지 확인
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        // given : 애플리케이션 실행 준비
        Application.main(new String[]{});
    }
}
