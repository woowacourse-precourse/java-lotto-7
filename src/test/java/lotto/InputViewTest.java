package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest {

    @Test
    @DisplayName("구매 금액 입력 - 정상 입력")
    void inputPurchaseAmount_ValidInput() {
        assertSimpleTest(() -> {
            run("5000");
            int purchaseAmount = InputView.inputPurchaseAmount();
            assertThat(purchaseAmount).isEqualTo(5000);
        });
    }

    @Test
    @DisplayName("구매 금액 입력 - 숫자가 아닌 값 입력 후 재입력")
    void inputPurchaseAmount_InvalidInput_NonNumeric() {
        assertSimpleTest(() -> {
            run("abc", "5000");
            int purchaseAmount = InputView.inputPurchaseAmount();
            assertThat(output()).contains("[ERROR] 숫자만 입력 가능합니다.");
            assertThat(purchaseAmount).isEqualTo(5000);
        });
    }

    @Test
    @DisplayName("구매 금액 입력 - 1000원 미만 입력 후 재입력")
    void inputPurchaseAmount_InvalidInput_LessThan1000() {
        assertSimpleTest(() -> {
            run("500", "1000");
            int purchaseAmount = InputView.inputPurchaseAmount();
            assertThat(output()).contains("[ERROR] 구매 금액은 1000원 이상이어야 합니다.");
            assertThat(purchaseAmount).isEqualTo(1000);
        });
    }

    @Test
    @DisplayName("구매 금액 입력 - 1000원 단위가 아닌 금액 입력 후 재입력")
    void inputPurchaseAmount_InvalidInput_NotMultipleOf1000() {
        assertSimpleTest(() -> {
            run("2500", "3000");
            int purchaseAmount = InputView.inputPurchaseAmount();
            assertThat(output()).contains("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
            assertThat(purchaseAmount).isEqualTo(3000);
        });
    }

    @Test
    @DisplayName("당첨 번호 입력 - 정상 입력")
    void inputWinningNumber_ValidInput() {
        assertSimpleTest(() -> {
            run("1,2,3,4,5,6");
            List<Integer> winningNumbers = InputView.inputWinningNumber();
            assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
        });
    }

    @Test
    @DisplayName("당첨 번호 입력 - 숫자가 아닌 값 입력 후 재입력")
    void inputWinningNumber_InvalidInput_NonNumeric() {
        assertSimpleTest(() -> {
            run("1,2,a,4,5,6", "1,2,3,4,5,6");
            List<Integer> winningNumbers = InputView.inputWinningNumber();
            assertThat(output()).contains("[ERROR] 숫자만 입력 가능합니다.");
            assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
        });
    }

    @Test
    @DisplayName("당첨 번호 입력 - 6개 미만 입력 후 재입력")
    void inputWinningNumber_InvalidInput_LessThan6Numbers() {
        assertSimpleTest(() -> {
            run("1,2,3,4,5", "1,2,3,4,5,6");
            List<Integer> winningNumbers = InputView.inputWinningNumber();
            assertThat(output()).contains("[ERROR] 당첨 번호는 6개여야 합니다.");
            assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
        });
    }

    @Test
    @DisplayName("당첨 번호 입력 - 1~45 범위 밖의 번호 입력 후 재입력")
    void inputWinningNumber_InvalidInput_NumberOutOfRange() {
        assertSimpleTest(() -> {
            run("1,2,3,4,5,46", "1,2,3,4,5,6");
            List<Integer> winningNumbers = InputView.inputWinningNumber();
            assertThat(output()).contains("[ERROR] 당첨 번호는 1~45 사이여야 합니다.");
            assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
        });
    }

    @Test
    @DisplayName("당첨 번호 입력 - 중복된 번호 입력 후 재입력")
    void inputWinningNumber_InvalidInput_DuplicateNumbers() {
        assertSimpleTest(() -> {
            run("1,2,3,3,5,6", "1,2,3,4,5,6");
            List<Integer> winningNumbers = InputView.inputWinningNumber();
            assertThat(output()).contains("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
            assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
        });
    }

    @Test
    @DisplayName("보너스 번호 입력 - 정상 입력")
    void inputBonusNumber_ValidInput() {
        assertSimpleTest(() -> {
            run("7");
            int bonusNumber = InputView.inputBonusNumber();
            assertThat(bonusNumber).isEqualTo(7);
        });
    }

    @Test
    @DisplayName("보너스 번호 입력 - 숫자가 아닌 값 입력 후 재입력")
    void inputBonusNumber_InvalidInput_NonNumeric() {
        assertSimpleTest(() -> {
            run("a", "7");
            int bonusNumber = InputView.inputBonusNumber();
            assertThat(output()).contains("[ERROR] 숫자만 입력 가능합니다.");
            assertThat(bonusNumber).isEqualTo(7);
        });
    }

    @Test
    @DisplayName("보너스 번호 입력 - 1~45 범위 밖의 번호 입력 후 재입력")
    void inputBonusNumber_InvalidInput_NumberOutOfRange() {
        assertSimpleTest(() -> {
            run("0", "7");
            int bonusNumber = InputView.inputBonusNumber();
            assertThat(output()).contains("[ERROR] 보너스 번호는 1~45 사이여야 합니다.");
            assertThat(bonusNumber).isEqualTo(7);
        });
    }

    @Override
    public void runMain() {
        // 테스트에서는 main 메서드를 실행하지 않습니다.
    }
}
