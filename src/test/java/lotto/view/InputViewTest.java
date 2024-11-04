package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("올바른 구매 금액 입력 시 정상 처리된다.")
    void inputPurchaseAmount_Valid() {
        assertSimpleTest(() -> {
            run("8000");
            int amount = InputView.inputPurchaseAmount();
            assertThat(amount).isEqualTo(8000);
        });
    }

    @Test
    @DisplayName("구매 금액이 1000원 단위가 아니면 예외가 발생한다.")
    void inputPurchaseAmount_Invalid_NotMultipleOf1000() {
        assertSimpleTest(() -> {
            run("8500");
            LottoException exception = assertThrows(LottoException.class, InputView::inputPurchaseAmount);
            assertThat(exception).hasMessage(ERROR_MESSAGE + " 구입 금액은 1000원 단위여야 합니다.");
        });
    }

    @Test
    @DisplayName("구매 금액이 음수이면 예외가 발생한다.")
    void inputPurchaseAmount_Invalid_Negative() {
        assertSimpleTest(() -> {
            run("-1000");
            LottoException exception = assertThrows(LottoException.class, InputView::inputPurchaseAmount);
            assertThat(exception).hasMessage(ERROR_MESSAGE + " 구입 금액은 1000원 단위여야 합니다.");
        });
    }

    @Test
    @DisplayName("구매 금액이 숫자가 아니면 예외가 발생한다.")
    void inputPurchaseAmount_Invalid_NonNumeric() {
        assertSimpleTest(() -> {
            run("eight thousand");
            LottoException exception = assertThrows(LottoException.class, InputView::inputPurchaseAmount);
            assertThat(exception).hasMessage(ERROR_MESSAGE + " 유효한 숫자를 입력해 주세요.");
        });
    }

    @Test
    @DisplayName("올바른 당첨 번호 입력 시 정상 처리된다.")
    void inputWinningNumbers_Valid() {
        assertSimpleTest(() -> {
            run("1, 2, 3, 4, 5, 6");
            List<Integer> winningNumbers = InputView.inputWinningNumbers();
            assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
        });
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    void inputWinningNumbers_InvalidCount() {
        assertSimpleTest(() -> {
            run("1, 2, 3, 4, 5");
            LottoException exception = assertThrows(LottoException.class, InputView::inputWinningNumbers);
            assertThat(exception).hasMessage(ERROR_MESSAGE + " 당첨 번호는 6개여야 합니다.");
        });
    }

    @Test
    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
    void inputWinningNumbers_Invalid_NonNumeric() {
        assertSimpleTest(() -> {
            run("1, 2, three, 4, 5, 6");
            LottoException exception = assertThrows(LottoException.class, InputView::inputWinningNumbers);
            assertThat(exception).hasMessage(ERROR_MESSAGE + " 당첨 번호는 숫자이어야 합니다.");
        });
    }

    @Test
    @DisplayName("올바른 보너스 번호 입력 시 정상 처리된다.")
    void inputBonusNumber_Valid() {
        assertSimpleTest(() -> {
            run("7");
            int bonusNumber = InputView.inputBonusNumber();
            assertThat(bonusNumber).isEqualTo(7);
        });
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    void inputBonusNumber_Invalid_NonNumeric() {
        assertSimpleTest(() -> {
            run("seven");
            LottoException exception = assertThrows(LottoException.class, InputView::inputBonusNumber);
            assertThat(exception).hasMessage(ERROR_MESSAGE + " 보너스 번호는 숫자이어야 합니다.");
        });
    }

    @Override
    public void runMain() {
        // InputView는 독립적으로 실행되지 않으므로 빈 구현
    }
}
