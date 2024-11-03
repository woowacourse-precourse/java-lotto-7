package lotto.domain;

import static lotto.domain.Amount.LOTTO_PRICE;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoBundleTest {

    @Test
    public void 로또묶음_발행_테스트() throws Exception {
        //Given
        int amount = 14000;
        int expected = 14;

        //When
        int actual = new LottoBundle(amount / LOTTO_PRICE).getBundle().size();

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}