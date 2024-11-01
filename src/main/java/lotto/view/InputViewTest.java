package lotto.view;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private void provideInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    // 각 테스트가 끝난 후 입력 스트림 초기화
    @AfterEach
    void restoreSystemInput() {
        System.setIn(System.in);
    }

    @Test
    @DisplayName("구입 금액 입력 - 1000원 단위의 입력을 정상적으로 받아 처리한다.")
    void inputPurchaseAmount_Valid() {
        provideInput("8000\n"); // Mocking user input of 8000
        int amount = InputView.inputPurchaseAmount();
        assertThat(amount).isEqualTo(8000);
    }

    @Test
    @DisplayName("구입 금액 입력 - 1000원 단위가 아닌 경우 예외를 발생시킨다.")
    void inputPurchaseAmount_Invalid() {
        provideInput("7500\n"); // Mocking user input of 7500
        assertThatThrownBy(InputView::inputPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_PURCHASE_AMOUNT);
    }

    @Test
    @DisplayName("당첨 번호 입력 - 6개의 유효한 당첨 번호를 입력받아 처리한다.")
    void inputWinningNumbers_Valid() {
        provideInput("1,2,3,4,5,6\n"); // Mocking user input of "1,2,3,4,5,6"
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호 입력 - 당첨 번호가 6개가 아닌 경우 예외를 발생시킨다.")
    void inputWinningNumbers_InvalidCount() {
        provideInput("1,2,3,4,5\n");
        assertThatThrownBy(InputView::inputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_WINNING_NUMBER_COUNT);
    }

    @Test
    @DisplayName("당첨 번호 입력 - 1~45의 범위를 벗어난 숫자를 입력 시 예외를 발생시킨다.")
    void inputWinningNumbers_OutOfRange() {
        provideInput("1,2,3,4,5,46\n"); // Mocking user input of "1,2,3,4,5,46"
        assertThatThrownBy(InputView::inputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_OUT_OF_RANGE);
    }

    @Test
    @DisplayName("보너스 번호 입력 - 1~45 사이의 보너스 번호를 정상적으로 입력받아 처리한다.")
    void inputBonusNumber_Valid() {
        provideInput("7\n"); // Mocking user input of 7
        int bonusNumber = InputView.inputBonusNumber();
        assertThat(bonusNumber).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호 입력 - 1~45 범위를 벗어난 경우 예외를 발생시킨다.")
    void inputBonusNumber_OutOfRange() {
        provideInput("50\n"); // Mocking user input of 50 (out of range)
        assertThatThrownBy(InputView::inputBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_OUT_OF_RANGE);
    }

    @Test
    @DisplayName("보너스 번호 입력 - 보너스 번호가 1개 이상 입력된 경우 예외를 발생시킨다.")
    void inputBonusNumber_MultipleNumbers() {
        provideInput("7,8\n"); // Mocking user input of "7,8" (more than one number)
        assertThatThrownBy(InputView::inputBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_BONUS_NUMBER);
    }
}
