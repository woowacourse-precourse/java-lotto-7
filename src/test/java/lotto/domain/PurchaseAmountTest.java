package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PurchaseAmountTest {
    @ParameterizedTest
    @CsvSource(value = {"-1", "0", "999"})
    void 금액이_부족한_경우_예외처리(int amount) {
        assertThatThrownBy(() -> new PurchaseAmount(amount)).isInstanceOf(IllegalArgumentException.class);
    }
}