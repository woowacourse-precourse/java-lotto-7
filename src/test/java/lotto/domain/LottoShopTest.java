package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoShopTest {
    @DisplayName("로또를 구매할 수 있다.")
    @ParameterizedTest
    @CsvSource("1, 1")
    void 로또_구매_테스트(int amount, int expectedSize) {
        LottoShop lottoShop = new LottoShop();
        Lottos lottos = lottoShop.buyLottos(amount);
        assertThat(lottos.size()).isEqualTo(expectedSize);
    }
}
