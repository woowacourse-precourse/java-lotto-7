package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    @DisplayName("로또를 구매하면 구매한 만큼의 로또를 가지고 있다.")
    @Test
    void 로또를_구매하면_구매한_만큼의_로또를_가지고_있다() {
        // given
        int money = 3000;
        Customer customer = new Customer(money);
        LottoStore lottoStore = new LottoStore();

        // when
        customer.purchaseLottoFrom(lottoStore);

        // then
        assertThat(customer.getLottos().size()).isEqualTo(3);
    }

    @DisplayName("로또를 구매하면 구매한 만큼의 금액이 차감된다.")
    @Test
    void 로또를_구매하면_구매한_만큼의_금액이_차감된다() {
        // given
        int money = 3000;
        Customer customer = new Customer(money);
        LottoStore lottoStore = new LottoStore();

        // when
        customer.purchaseLottoFrom(lottoStore);

        // then
        assertThat(customer.getMoney()).isEqualTo(0);
    }
}
