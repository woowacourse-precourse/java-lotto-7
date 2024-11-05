package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BudgetTest {

    @Test
    @DisplayName("1000원 단위의 숫자를 정확하게 받는지 기능 테스트")
    void BudgetUnitOfOneThousand() {

        Budget testBudget = new Budget("2000");

        assertThat(testBudget.getAmount()).isEqualTo(2000);
    }

    @Test
    @DisplayName("구입 금액에 숫자 이외의 값이 들어오면 예외 처리")
    void BudgetNumericTest() {

        assertThatThrownBy(() -> new Budget("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액에 자연수 이외의 값이 들어오면 예외 처리")
    void BudgetNaturalNumberTest() {

        assertThatThrownBy(() -> new Budget("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액에 1000원으로 나누어 떨어지지 않는 경우 예외 처리")
    void BudgetDividedOneThousandTest() {

        assertThatThrownBy(() -> new Budget("1005"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}