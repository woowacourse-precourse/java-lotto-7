package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BudgetTest {

    @Test
    @DisplayName("올바른 예산이 들어왔을 때, 예외 없이 생성됨")
    void givenCorrectBudget_whenBudget_thenNonThrowException() {
        int input = 1000;
        Assertions.assertDoesNotThrow(() -> new Budget(input));
    }

    @Test
    @DisplayName("1000원 단위가 아닌 예산이 들어 왔을 때, IllegalArgumentException을 던짐")
    void givenInvalidBudget_whenBudget_thenThrowIllegalArgumentException() {
        int input = 1500;
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Budget(input));
    }

    @Test
    @DisplayName("올바른 구매 장수를 계산한다.")
    void givenCorrectBudget_whenCalculateNumberOfLottos_thenCorrect() {
        Budget budget = new Budget(8000);
        int excepted = 8;
        int result = budget.calculateNumberOfLotto();
        Assertions.assertEquals(excepted, result);
    }

}