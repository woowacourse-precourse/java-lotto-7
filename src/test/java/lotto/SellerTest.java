package lotto;

import static lotto.Seller.countNumberOfLotto;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SellerTest {
    @Test
    public void countNumberOfLottoTest() {
        //given
        int purchaseAmount = 8000;
        int expected = purchaseAmount / 1000;

        //when
        int actual = countNumberOfLotto(purchaseAmount);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
