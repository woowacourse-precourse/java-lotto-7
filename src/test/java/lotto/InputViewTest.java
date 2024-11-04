package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest extends NsTest {

    @Test
    void 구매금액_입력_정상입력() {
        run("8000");
        int purchaseAmount = InputView.inputPurchaseAmount();
        assertThat(purchaseAmount).isEqualTo(8000);
    }

    @Test
    void 구매금액_입력_비정상입력_예외발생() {
        run("abc");
        assertThatThrownBy(() -> {
            InputView.inputPurchaseAmount();
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력 - 정상 입력")
    void 당첨번호_입력_정상입력() {
        run("1, 2, 3, 4, 5, 6");
        List<Integer> winningNumbers = InputView.inputWinningNumber();
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호 입력 - 비정상 입력 예외 발생")
    void 당첨번호_입력_비정상입력_예외발생() {
        run("1, 2, 3, a, 5, 6");
        assertThatThrownBy(InputView::inputWinningNumber)
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string: \"a\"");
    }

    @Test
    @DisplayName("보너스 번호 입력 - 정상 입력")
    void 보너스번호_입력_정상입력() {
        run("7");
        int bonusNumber = InputView.inputBonusNumber();
        assertThat(bonusNumber).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호 입력 - 비정상 입력 예외 발생")
    void 보너스번호_입력_비정상입력_예외발생() {
        run("notANumber");
        assertThatThrownBy(InputView::inputBonusNumber)
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string: \"notANumber\"");
    }
    @Override
    protected void runMain() {

    }

}
