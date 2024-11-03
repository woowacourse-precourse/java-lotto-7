package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Wallet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PaymentTest {

    private static final Integer MIN_MONEY_UNIT = 1000;

    @DisplayName("구입한 로또의 개수를 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 13000, 140000, 1500000, 132000, 333000})
    void 구입한_로또의_개수를_확인한다(Integer input) {
        Wallet wallet = new Wallet(input);

        Payment payment = Payment.create(wallet);

        assertThat(payment.getWalletMoney()).isEqualTo(input);
        assertThat(payment.getLottoCount()).isEqualTo(input / MIN_MONEY_UNIT);
    }
}