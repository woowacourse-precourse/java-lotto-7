package lotto.utils;

import lotto.model.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}