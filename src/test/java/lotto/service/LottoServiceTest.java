package lotto.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    void 발행한_로또의_수량이_올바른지_테스트() {
        // given
        int purchaseAmount = 5000;
        int expected = purchaseAmount / 1000;

        // when
        int result = lottoService.calculateLottoQuantities(purchaseAmount);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
