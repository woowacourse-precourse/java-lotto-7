package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    @DisplayName("입력된 금액을 정확히 저장")
    void saveExactlyMoney() {
        String input = "5000";

        Money money = new Money(input);

        assertThat(money.getValue()).isEqualTo(Integer.parseInt(input));
    }
}