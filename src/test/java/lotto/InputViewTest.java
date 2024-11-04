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
    @DisplayName("숫자가 아닌 값 입력 시 예외 발생")
    void inputPurchaseAmount_숫자가_아닌_값() {
        run("abc");

        assertThatThrownBy(() -> {
            InputView.inputPurchaseAmount();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("1000원 단위로 나눠 떨어지지 않는 금액 입력 시 예외 발생")
    void inputPurchaseAmount_1000원으로_나눠_떨어지지_않는_값() {
        run("1500");

        assertThatThrownBy(() -> {
            InputView.inputPurchaseAmount();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("1000원 미만 금액 입력 시 예외 발생")
    void inputPurchaseAmount_1000원_미만_값() {
        run("0");

        assertThatThrownBy(() -> {
            InputView.inputPurchaseAmount();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 1000원 이상이어야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호 입력 - 정상 입력")
    void 당첨번호_입력_정상입력() {
        run("1,2,3,4,5,6");
        List<Integer> winningNumbers = InputView.inputWinningNumber();
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호 입력 - 비정상 입력 예외 발생")
    void 당첨번호_입력_비정상입력_예외발생() {
        run("1,2,3,a,5,6");
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
