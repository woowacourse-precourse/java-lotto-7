package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoIssueServiceTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("당첨 번호와 보너스번호를 입력하면 당첨 로또가 반환된다.")
    @Test
    void issue() {
        // given
        String inputLottoNums = "1,2,3,4,5,6";
        String bonus = "7";
        // when & then
        assertSimpleTest(
                () -> {
                    run(inputLottoNums, bonus);
                    assertThat(output()).contains("[1, 2, 3, 4, 5, 6]");
                }
        );
    }

    @DisplayName("보너스 번호가 로또 번호 범위르 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void validateBonusNumRange(String bonus) {
        // given
        String inputLottoNums = "1,2,3,4,5,6";
        // when & then
        assertSimpleTest(
                () -> {
                    runException(inputLottoNums, bonus);
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void validateBonusNumDuplication(String bonus) {
        // given
        String inputLottoNums = "1,2,3,4,5,6";
        // when & then
        assertSimpleTest(
                () -> {
                    runException(inputLottoNums, bonus);
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }


    @Override
    protected void runMain() {
        WinningLottoIssueService service = new WinningLottoIssueService();
        System.out.println(service.issue("당첨 번호를 입력해 주세요."));
    }
}