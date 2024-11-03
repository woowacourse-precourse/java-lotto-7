package lotto;

import lotto.view.ValidatorOfView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorOfViewTest {
    @Test
    @DisplayName("로또 구입 금액 - 1000으로 떨어지지 않는 경우")
    public void isMultipleOfUnitPrice() {
        // given
        int input = 1500;
        // when & then
        Assertions.assertThatThrownBy(() -> ValidatorOfView.isValidBudget(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    @Test
    @DisplayName("로또 구입 금액 - 자연수가 아닌 경우")
    public void isValidBudget() {
        // given
        int input = -1;
        // when & then
        Assertions.assertThatThrownBy(() -> ValidatorOfView.isValidBudget(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


}
