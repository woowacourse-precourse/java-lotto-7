package lotto.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private final LottoService lottoService = new LottoServiceImpl();

    @Test
    void 로또_구입_정상_금액_입력_테스트() {
        int purchaseAmount = 5000;
        int expectedLottoCount = 5;

        int lottoCount = lottoService.calculateLottoCount(purchaseAmount);

        assertThat(lottoCount).isEqualTo(expectedLottoCount);
    }
}
