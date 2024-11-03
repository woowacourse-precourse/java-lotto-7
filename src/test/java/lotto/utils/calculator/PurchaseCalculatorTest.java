package lotto.utils.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Money;
import lotto.utils.Calculator.PurchaseCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseCalculatorTest {

    @Test
    @DisplayName("정상 금액 로또 수 계산 검증")
    void 정상_금액_로또_수_계산_검증() {
        //given
        Money money = new Money(5000);

        //when
        int lottoCount = PurchaseCalculator.calculateLottoCount(money);

        //then
        assertThat(lottoCount).isEqualTo(5);
    }
}
