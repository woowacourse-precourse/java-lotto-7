package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputServiceWinningLottoTest extends NsTest {

    private static final String INT_ERROR = "숫자가";
    private static final String EMPTY_ERROR = "비어있습니다";
    private final InputService InputService = new InputService(new InputView());
    private WinningLotto winningLotto;

    @Test
    void 당첨_번호_빈값_실패() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(EMPTY_ERROR);
        });
    }

    @Test
    void 보너스_숫자_빈값_실패() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(EMPTY_ERROR);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", " 1000 "})
    void 보너스_숫자_int로_변환_실패_문자(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(INT_ERROR);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2.3,4,5,6", "a,1,2,3,4,5"})
    void 당첨번호_입력_문자_예외_실패(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains("문자가");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "0,1,2,3,4,5", "1,1,2,3,4,5"})
    void 당첨번호_입력_로또_변환_실패(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains("로또 번호는");
        });
    }

    @Test
    void 보너스번호_당첨번호와_중복_실패() {
        assertSimpleTest(() -> {
            runException("1,2,3,4,5,6\n1");
            assertThat(output()).contains("당첨 번호에 없는");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6\n-1", "1,2,3,4,5,6\n0", "1,2,3,4,5,6\n70"})
    void 보너스번호_로또번호_범위_미만또는초과_실패(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains("사이여야");
        });
    }

    @Test
    void 당첨번호_보너스번호_변환성공() {
        assertSimpleTest(() -> {
            run("1,2,3,4,5,6\n7");
            Assertions.assertThat(winningLotto.countMatches(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
        });
    }

    @Override
    protected void runMain() {
        winningLotto = InputService.readWinningLotto();
    }

}
