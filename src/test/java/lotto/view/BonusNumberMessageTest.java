package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.constants.errorType.BonusNumberErrorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BonusNumberMessageTest extends NsTest {

    @Test
    @DisplayName("보너스 당첨 번호의 범위가 1~45가 아닐경우 테스트1")
    void 보너스_당첨_번호_범위_테스트1() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(BonusNumberErrorType.INVALID_BONUS_NUMBER_RANGE.getMessage());
        });
    }

    @Test
    @DisplayName("보너스 당첨 번호의 범위가 1~45가 아닐경우 테스트2")
    void 보너스_당첨_번호_범위_테스트2() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", "-1");
            assertThat(output()).contains(BonusNumberErrorType.INVALID_BONUS_NUMBER_RANGE.getMessage());
        });
    }

    @Test
    @DisplayName("보너스 당첨 번호가 공백일 경우 테스트")
    void 보너스_당첨_번호가_공백일_경우_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", " ");
            assertThat(output()).contains(BonusNumberErrorType.BONUS_NUMBER_NULL_ERROR.getMessage());
        });
    }

    @Test
    @DisplayName("잘못된 형식의 보너스 당첨 번호일 경우")
    void 잘못된_형식_보너스_당첨_번호_입력_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", "십사");
            assertThat(output()).contains(BonusNumberErrorType.INVALID_BONUS_NUMBER_FORMAT.getMessage());
        });
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호에 이미 존재할 경우")
    void 보너스_번호가_이미_존재할_경우() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(BonusNumberErrorType.DUPLICATE_BONUS_NUMBER.getMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
