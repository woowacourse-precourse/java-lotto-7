package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.LottoGenerator;
import lotto.model.LottoTicket;
import lotto.model.LottoTicketGenerator;
import lotto.model.PurchaseAmount;
import org.junit.jupiter.api.Test;

class LottoTicketGeneratorTest {
    @Test
    void 구매_가능한_개수만큼_로또가_생성되는지_확인() {
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator(
                new LottoGenerator(),
                PurchaseAmount.from("10000")
        );

        LottoTicket lottoTicket = lottoTicketGenerator.generateLottoTicket();
        assertThat(lottoTicket.getLottos().size()).isEqualTo(10);
    }
}
