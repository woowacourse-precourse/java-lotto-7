package lotto;

import static lotto.Seller.countNumberOfLotto;
import static lotto.Seller.giveLotto;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5})
    public void giveLottoTest(int numberOfLotto) {
        //when
        List<Lotto> lottos = giveLotto(numberOfLotto);

        //then
        assertThat(lottos.size()).isEqualTo(numberOfLotto);
    }
}
