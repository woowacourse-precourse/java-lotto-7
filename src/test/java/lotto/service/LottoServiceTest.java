package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @DisplayName("로또 구매 개수 확인")
    @Test
    void lottoPurchaseAmountTest() {
        LottoService lottoService = new LottoService();
        int amount = 8000;

        lottoService.purchaseLottos(amount);

        assertThat(lottoService.getPurchasedLottos()).hasSize(8);
    }
}
