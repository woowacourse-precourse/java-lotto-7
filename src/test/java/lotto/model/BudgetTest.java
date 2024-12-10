package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BudgetTest {


    @DisplayName("입력 금액과 같은 금액의 Budget이 생성된다.")
    @Test
    void EXACTLY_SAME_AMOUNT_OF_BUDGET() {
        Long amount = 1000L;
        Budget budget = Budget.of(amount);
        assertEquals(amount, budget.getAmount());
    }

    @DisplayName("로또 구입 금액이 음수이면 예외를 일으킨다.")
    @Test
    void ERROR_BUDGET_NEGATIVE_NUMBER() {
        Long amount = -1000L;
        assertThrowsExactly(IllegalArgumentException.class, () -> Budget.of(amount),
                ErrorMessage.BUDGET_NEGATIVE_NUMBER.message());
    }

    @DisplayName("로또 구입 금액이 1000원으로 나누어 떨어지지 않으면 예외를 일으킨다.")
    @Test
    void ERROR_BUDGET_INVALID_UNIT() {
        Long amount = 100L;
        assertThrowsExactly(IllegalArgumentException.class, () -> Budget.of(amount),
                ErrorMessage.BUDGET_INVALID_UNIT.message());
    }
}