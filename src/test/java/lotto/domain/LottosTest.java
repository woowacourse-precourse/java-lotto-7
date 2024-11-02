package lotto.domain;

import lotto.application.numberstrategy.MakingRandomNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 리스트에 관한 기능을 확인한다.")
class LottosTest {

    @Test
    @DisplayName("로또 리스트 생성을 확인한다.")
    void makingLottos() {
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