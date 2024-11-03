package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    void 구입_개수_테스트() {
        int purchaseAmount = 8000;

        LottoService lottoService = new LottoService();
        assertThat(lottoService.getPurchaseCount(purchaseAmount))
                .isEqualTo(8);
    }
}
