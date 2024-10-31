package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.BudgetErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BudgetTest {

    @Test
    @DisplayName("예산이 0 미만일 경우 예외를 발생시킨다.")
    void validateBudgetRangeTest() {
        // given
        final int budget = -1;

        // when && then
        assertThatThrownBy(() -> new Budget(budget))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BudgetErrorMessage.BUDGET_RANGE_ERROR.getMessage());
    }

    @Test
    @DisplayName("예산이 1000원 단위가 아닐 경우 예외를 발생시킨다.")
    void validateBudgetUnitTest() {
        // given
        final int budget = 1001;

        // when && then
        assertThatThrownBy(() -> new Budget(budget))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BudgetErrorMessage.BUDGET_UNIT_ERROR.getMessage());
    }

}