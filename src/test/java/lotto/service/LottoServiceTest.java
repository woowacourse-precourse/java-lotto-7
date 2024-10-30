package lotto.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoServiceTest {

    private final LottoService lottoService;
    /*
    발행한 로또 수량 테스트
    구입 금액을 1000으로 나눈 수가 맞는지 테스트
     */

    @Test
    void 발행한_로또의_수량이_올바른지_테스트() {
        // given
        int purchaseAmount = 5000;
        int answer = purchaseAmount % 1000;

        // when
        int result = lottoService.calculateLottoQuantities(purchaseAmount);

        // then
        assertThat(result).isEqualTo(result);
    }
}
