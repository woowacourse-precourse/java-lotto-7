package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.factory.WalletFactory;
import lotto.service.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProfitCalculatorTest {

    private static final Integer PERCENT = 100;

    private Payment payment;

    @BeforeEach
    void before_each() {
        payment = Payment.create(WalletFactory.create(10000));
    }

    @DisplayName("당첨 금액에 따라 수익률을 계산해 반환한다.")
    @ParameterizedTest
    @ValueSource(longs = {5000, 100000, 50000, 1500000, 30000000, 2000000000})
    void 당첨_금액에_따라_수익률을_계산해_반환한다(long prizeMoney) {
        double correctProfit = (double) prizeMoney / payment.getWalletMoney() * PERCENT;

        double newProfit = ProfitCalculator.calculate(payment, prizeMoney);

        assertThat(newProfit).isEqualTo(correctProfit);
    }
}