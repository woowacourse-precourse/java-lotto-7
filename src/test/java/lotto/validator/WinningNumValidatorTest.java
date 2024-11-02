package lotto.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.ExceptionMessage.INVALID_BONUS_RANGE;
import static lotto.constant.ExceptionMessage.INVALID_WINNING_CHAR;
import static lotto.constant.ExceptionMessage.INVALID_WINNING_COUNT;
import static lotto.constant.ExceptionMessage.INVALID_WINNING_DELIMITER;
import static lotto.constant.ExceptionMessage.INVALID_WINNING_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumValidatorTest extends NsTest {

    @ParameterizedTest
    @CsvSource({"1,2,3,4,5,6:", "1,2,3,4,5 6"})
    @DisplayName("당첨 번호는 숫자 및 구분자인 , 외의 문자를 포함할 수 없다.")
    void 당첨_번호_문자_종류_예외_테스트(String winning) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("8000", winning))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_WINNING_CHAR.getMessage())
        );
    }

    @Test
    @DisplayName("당첨 번호는 구분자인 ,를 연속적으로 포함할 수 없다.")
    void 당첨_번호_구분자_연속_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("8000", "1,2,3,4,5,,6"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_WINNING_DELIMITER.getMessage())
        );
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,4,5", "1,2,3,4,5,6,7"})
    @DisplayName("당첨 번호는 구분자인 ,를 기준으로 6개로 구분되어야 한다.")
    void 당첨_번호_갯수_예외_테스트(String winning) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("8000", winning))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_WINNING_COUNT.getMessage())
        );
    }

    @ParameterizedTest
    @CsvSource({"0", "46"})
    @DisplayName("당첨 번호는 구분되는 각 숫자가 1 이상 45 이하여야 한다.")
    void 당첨_번호_범위_예외_테스트(String winning) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("8000", winning))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_WINNING_RANGE.getMessage())
        );
    }

    @ParameterizedTest
    @CsvSource({"0", "46"})
    @DisplayName("보너스 번호는 1 이상 45 이하의 숫자여야 한다.")
    void 보너스_번호_범위_예외_테스트(String winning) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("8000", winning))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_BONUS_RANGE.getMessage())
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
