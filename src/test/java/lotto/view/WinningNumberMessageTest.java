package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.constants.errorType.WinningNumberErrorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberMessageTest extends NsTest {

    @Test
    @DisplayName("로또 당첨 번호가 1~45가 아닐 경우 테스트")
    void 로또_당첨_번호_범위_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,46,4,5");
            assertThat(output()).contains(WinningNumberErrorType.INVALID_WINNING_NUMBER_RANGE.getMessage());
        });
    }

    @Test
    @DisplayName("로또 당첨 번호가 올바른 형식이 아닐 경우 테스트")
    void 로또_당첨_번호_형식_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,삼,4,5");
            assertThat(output()).contains(WinningNumberErrorType.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
