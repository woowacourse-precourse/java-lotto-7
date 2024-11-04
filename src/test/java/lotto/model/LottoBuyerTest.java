package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBuyerTest {

    @Test
    void 천원_단위로_구입금액을_입력하면_로또를_살_수_있다() {
        LottoBuyer lottoBuyer = new LottoBuyer(new LottoMachine(new LottoGenerator()));
        Lottos lottos = lottoBuyer.buyLottos(new Money(3000L));

        assertThat(lottos.size()).isEqualTo(3);
    }
}