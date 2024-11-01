package lotto;

import lotto.model.Money;
import lotto.utils.LottoMachine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {

    @DisplayName("금액에 맞게 올바른 수의 중복되지 않은 로또를 생성해야한다.")
    @ParameterizedTest
    @CsvSource({
            "1000, 1",
            "2000, 2",
            "11000, 11"
    })
    void shouldPurchaseLotto(int price, int result) {
        Money money = new Money(price);

        Assertions.assertThat(LottoMachine.purchaseLottos(money).size())
                .isEqualTo(result);
    }

    @DisplayName("티켓 가격으로 나누어떨어지지 않는 금액인지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1_001, 2_095, 1_05, 9_500, 1_000_000, -1000, 0, -9000})
    void throwExceptionIfIsInvalidMoneyTicketPrice(int price) {
        Money money = new Money(price);

        Assertions.assertThatThrownBy(() -> LottoMachine.purchaseLottos(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}