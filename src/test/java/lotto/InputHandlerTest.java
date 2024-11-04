package lotto;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    @Test
    void 로또_구입금액이_1000단위가_아닐경우_예외_발생() {
        // Given
        int budget = 5500;
        // When
        InputHandler inputHandler = new InputHandler();
        // Then
        Assertions.assertThatThrownBy(() -> inputHandler.budgetInputValidator(budget))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1000단위만 가능합니다.");
    }

    @Test
    void 로또_구입금액이_1000미만일_경우_예외_발생() {
        // Given
        int budget = 0;
        // When
        InputHandler inputHandler = new InputHandler();
        // Then
        Assertions.assertThatThrownBy(() -> inputHandler.budgetInputValidator(budget))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1000 이상부터 가능합니다.");
    }

    @Test
    void 로또_당첨번호에_보너스번호가_존재할_경우_예외_발생() {
        // Given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 3;
        // When
        InputHandler inputHandler = new InputHandler();
        // Then
        Assertions.assertThatThrownBy(() -> inputHandler.bonusNumberValidator(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호에 보너스번호와 중복된 숫자가 존재합니다.");
    }

    @Test
    void 보너스번호가_1부터_45사이가_아닐_경우_예외_발생() {
        // Given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 55;
        // When
        InputHandler inputHandler = new InputHandler();
        // Then
        Assertions.assertThatThrownBy(() -> inputHandler.bonusNumberValidator(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스번호는 1~45사이의 정수여야 합니다.");
    }
}