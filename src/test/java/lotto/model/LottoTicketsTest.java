package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @Test
    @DisplayName("유효한 구매 금액으로 LottoTickets 객체가 정상적으로 생성된다.")
    void createLottoTickets_withValidPurchaseAmount() {
        int validAmount = 10000;
        PurchaseAmount purchaseAmount = new PurchaseAmount(validAmount);

        LottoTickets lottoTickets = new LottoTickets(purchaseAmount);

        assertThat(lottoTickets.getLottoCount()).isEqualTo(validAmount / PurchaseAmount.LOTTO_PRICE);
        assertThat(lottoTickets.getLottos()).hasSize(lottoTickets.getLottoCount());
    }

    @Test
    @DisplayName("구입 금액 조회가 올바르게 작동하는지 확인한다.")
    void getPurchaseAmount_returnsCorrectAmount() {
        int validAmount = 15000;
        PurchaseAmount purchaseAmount = new PurchaseAmount(validAmount);

        LottoTickets lottoTickets = new LottoTickets(purchaseAmount);

        assertThat(lottoTickets.getPurchaseAmount()).isEqualTo(validAmount);
    }
}
