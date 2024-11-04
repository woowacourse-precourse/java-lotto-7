package lotto;

import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("로또 구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {1500, 2200, 1100})
    void createMoneyWithInvalidUnit(int amount) {
        assertThatThrownBy(() -> Money.from(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @DisplayName("로또 구입 금액이 0원 이하일 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, -1000, -2000})
    void createMoneyWithNegativeAmount(int amount) {
        assertThatThrownBy(() -> Money.from(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 0보다 커야 합니다.");
    }

    @DisplayName("로또 구입 금액으로 구매 가능한 로또 수량을 계산한다")
    @Test
    void calculateLottoQuantity() {
        Money money = Money.from(5000);
        assertThat(money.getLottoQuantity()).isEqualTo(5);
    }

    @DisplayName("수익률을 계산한다")
    @Test
    void calculateProfitRate() {
        Money purchaseMoney = Money.from(1000);
        Money prizeMoney = Money.from(5000);

        assertThat(purchaseMoney.calculateProfitRate(prizeMoney)).isEqualTo(500.0);
    }
}