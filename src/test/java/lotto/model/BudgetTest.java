package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.BudgetException;
import lotto.model.budget.Budget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BudgetTest {

    @DisplayName("예산이 0원으로 설정되면 예외를 처리한다.")
    @Test
    void 예산_0원_예외() {
        assertThatThrownBy(() -> new Budget(0))
                .isInstanceOf(BudgetException.class);
    }

    @DisplayName("예산이 1000원 단위가 아니라면 예외를 처리한다.")
    @Test
    void 예산_단위_예외() {
        assertThatThrownBy(() -> new Budget(1001))
                .isInstanceOf(BudgetException.class);
    }

    @DisplayName("예산이 음수로 설정되면 예외를 처리한다.")
    @Test
    void 예산_음수_예외() {
        assertThatThrownBy(() -> new Budget(-1000))
                .isInstanceOf(BudgetException.class);
    }
}
