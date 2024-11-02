package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoIssuer;
import lotto.model.PurchaseAmount;
import lotto.model.RandomLottoIssuer;
import org.junit.jupiter.api.Test;

class LottoIssuingServiceTest {

    @Test
    void 로또를_구입_금액만큼_발행한다() {
        // given
        LottoIssuer lottoIssuer = new RandomLottoIssuer();
        LottoIssuingService lottoService = new LottoIssuingService(lottoIssuer);
        PurchaseAmount amount = PurchaseAmount.from(12000);

        // when
        List<Lotto> lottoTickets = lottoService.issueForAmount(amount);

        // then
        assertThat(lottoTickets).hasSize(12);
    }
}