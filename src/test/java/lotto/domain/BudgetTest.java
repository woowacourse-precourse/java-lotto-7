package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -1000})
    void 양수가_아니라면_예외가_발생한다(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Budget(input);
                }).withMessageContaining("양수를 입력하셔야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 1, 2001})
    void 천으로_나눠질_수_없다면_예외가_발생한다(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Budget(input);
                }).withMessageContaining("1,000원으로 나눠질 수 있는 금액을 입력하셔야 합니다.");
    }

    @Test
    void 수익률을_계산한다() {
        Budget budget = new Budget(9000);
        int totalAmount = 8000;

        double rateOfReturn = budget.findRateOfReturn(totalAmount);

        assertEquals(88.89, rateOfReturn);
    }
}