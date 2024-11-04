package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.controller.LottoController;
import lotto.global.message.ErrorMessage;
import lotto.global.message.InputMessage;
import lotto.global.message.OutputMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest extends NsTest {

    private int countOccurrences(String text) {
        String[] lines = text.split(OutputMessage.NEW_LINE);
        int count = 0;
        for (String line : lines) {
            if (line.equals(InputMessage.BONUS_NUMBER)) {
                count++;
            }
        }
        return count;
    }

    @DisplayName("보너스 번호를 잘못 입력 했을 때 보너스 번호 부터 입력을 다시 받는다.")
    @Test
    void completeGameAfterRetryBonusNumber() {
        // given & when
        run("1000", "1,2,3,4,5,6", "0", "1", "7");

        // then
        String outputString = output();
        int promptCount = countOccurrences(outputString);

        assertThat(promptCount).isEqualTo(3);
        assertThat(outputString)
                .contains(ErrorMessage.INVALID_BONUS_NUMBER_RANGE)
                .contains(ErrorMessage.DUPLICATE_BONUS_NUMBER)
                .contains(OutputMessage.STATISTICS_HEADER);
    }

    @Override
    protected void runMain() {
        LottoController controller = new LottoController();
        controller.run();
    }
}