package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputViewTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 지불_단위_예외_테스트() {
        assertSimpleTest(() -> {
            runException("550");
            assertThat(output()).contains(ERROR_MESSAGE); // 1,000 단위가 아닌 금액 예외 확인
        });
    }
    @Test
    void 지불_범위_예외_테스트() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ERROR_MESSAGE); // 1,000 단위가 아닌 금액 예외 확인
        });
    }

    @Test
    void 당첨_번호_형식_예외_테스트() {
        assertSimpleTest(() -> {
            runException("8000", "일,이,삼,사,오,육"); // 당첨 번호가 6개가 아닐 때 예외 처리
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨_번호_갯수_초과_예외_테스트() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6,7,8,9,10,11,12"); // 당첨 번호가 6개가 아닐 때 예외 처리
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨_번호_갯수_미달_예외_테스트() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5"); // 당첨 번호가 6개가 아닐 때 예외 처리
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨_번호_중복_예외_테스트() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,3,5,6", "7"); // 당첨 번호 중복 예외 확인
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨_번호_범위_예외_테스트() {
        assertSimpleTest(() -> {
            runException("8000", "0,2,3,4,5,6", "7"); // 로또 번호 범위 초과
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스_번호_범위_예외_테스트() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "46"); // 보너스 번호 범위 초과 예외 확인
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 보너스_번호_형식_예외_테스트() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "칠"); // 보너스 번호 범위 초과 예외 확인
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스_번호_중복_예외_테스트() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "6"); // 보너스 번호가 당첨 번호에 포함된 경우 예외 확인
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
