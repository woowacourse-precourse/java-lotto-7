package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoSellerTest {

    @Test
    void 돈이_부족할_때까지_로또를_산다() {
        //given
        LottoSeller lottoSeller = new LottoSeller(new LottoMachine());

        //when
        Lottos lottos = lottoSeller.sellUntilNoMoney(Money.from(5000), ((min, max, size) -> List.of(1, 2, 3, 4, 5, 6)));

        //then
        Assertions.assertThat(lottos.getLottos()).hasSize(5)
                .extracting("numbers")
                .contains(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6)
                );
    }
}