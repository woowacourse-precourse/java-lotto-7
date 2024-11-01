package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoQuantityTest {

    @Test
    @DisplayName("금액에 따른 수량을 확인한다.")
    void findQuantity() {
        //given
        int purchasePrice = 5000;

        //when
        LottoQuantity lottoQuantity = LottoQuantity.findQuantity(purchasePrice);

        //then
        Assertions.assertThat(lottoQuantity.value()).isEqualTo(5);
    }
}