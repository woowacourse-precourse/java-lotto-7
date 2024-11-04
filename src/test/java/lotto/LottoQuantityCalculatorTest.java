package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoQuantityCalculatorTest {

    private final LottoQuantityCalculator calculator = new LottoQuantityCalculator();

    @DisplayName("검증된 입력금액에 따른 로또 수량 계산")
    @Test
    void 검증된_입력금액에_따른_로또_수량_계산() {
        int validatedPurchaseAmount = 5000;

        int quantity = calculator.calculateLottoQuantity(validatedPurchaseAmount);

        assertThat(quantity).isEqualTo(5);
    }
}
