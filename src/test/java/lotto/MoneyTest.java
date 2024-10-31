package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {
    @ParameterizedTest
    @DisplayName("돈 1,000원 당 로또 티켓 1개로 교환할 수 있다")
    @ValueSource(ints = 1000)
    void 돈_티켓_교환_테스트(int amount) {
        int expected = 1;
        Money money = new Money(amount);
        assertThat(money.getTicket()).isEqualTo(expected);
    }
}
