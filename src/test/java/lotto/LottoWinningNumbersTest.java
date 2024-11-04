package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningNumbersTest extends NsTest {
    @DisplayName("로또 당첨번호에 문자가 있으면 예외가 발생한다.")
    @Test
    void 로또_당첨번호에_문자가_있으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,a");
            assertThat(output()).contains(Constants.WRONG_RANGE);
        });
    }
    @DisplayName("로또 당첨번호에 콤마로 구분되어 있지 않으면 예외가 발생한다.")
    @Test
    void 로또_당첨번호에_콤마로_구분되어_있지_않으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1;2;3;4;5;6");
            assertThat(output()).contains(Constants.NOT_INPUT_COMMA);
        });
    }
    @DisplayName("로또 당첨번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_당첨번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,1,2,3,4,5");
            assertThat(output()).contains(Constants.DUPLICATE_NUMBER);
        });
    }
    @DisplayName("로또 당첨번호가 1부터 45 까지 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 로또_당첨번호가_1부터_45_까지_범위를_벗어나면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,46");
            assertThat(output()).contains(Constants.WRONG_RANGE);
        });
    }
    @DisplayName("로또 당첨번호 개수가 6개를 넘어가면 예외가 발생한다")
    @Test
    void 로또_당첨번호_개수가_6개를_넘어가면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(Constants.WRONG_LENGTH);
        });
    }
    @DisplayName("로또 보너스번호에 문자가 있으면 예외가 발생한다.")
    @Test
    void 로또_보너스번호에_문자가_있으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(Constants.WRONG_RANGE);
        });
    }
    @DisplayName("로또 보너스번호가 1부터 45 까지 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 로또_보너스번호가_1부터_45_까지_범위를_벗어나면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(Constants.WRONG_RANGE);
        });
    }
    @DisplayName("로또 보너스번호가 로또 당첨번호와 중복이면 예외가 발생한다.")
    @Test
    void 로또_보너스번호가_로또_당첨번호와_중복이면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(Constants.DUPLICATE_BONUS_NUMBER);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}