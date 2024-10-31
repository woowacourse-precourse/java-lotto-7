package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.dto.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoIssuerTest {

    private final LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();

    @Test
    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행한다.")
    void should_IssueLottosByPurchaseAmount() {
        // given
        LottoIssuer lottoIssuer = new LottoIssuer(lottoNumbersGenerator);
        PurchaseAmount purchaseAmount = new PurchaseAmount(5000);

        // when
        LottoTickets lottoTickets = lottoIssuer.issueLottoTickets(purchaseAmount);

        // then
        assertThat(lottoTickets.tickets()).hasSize(5);
    }
}
