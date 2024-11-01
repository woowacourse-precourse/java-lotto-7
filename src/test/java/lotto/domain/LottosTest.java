package lotto.domain;

import lotto.application.numberstrategy.MakingRandomNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void from() {
        //given
        LottoQuantity lottoQuantity = new LottoQuantity(2);
        MakingRandomNumbers makingRandomNumbers = new MakingRandomNumbers();

        //when
        Lottos lottos = Lottos.from(lottoQuantity, makingRandomNumbers);
        int lottosSize = lottos.value().size();

        //then
        Assertions.assertThat(lottosSize).isEqualTo(2);
    }
}