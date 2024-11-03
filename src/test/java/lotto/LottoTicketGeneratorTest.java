package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.lotto.LottoGenerator;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.LottoTicketGenerator;
import lotto.model.lotto.PurchaseAmount;
import org.junit.jupiter.api.Test;

class LottoTicketGeneratorTest {
    @Test
    void 구매_가능한_개수만큼_로또가_생성되는지_확인() {
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator(
                new LottoGenerator()
        );

        LottoTicket lottoTicket = lottoTicketGenerator.generateLottoTicket(PurchaseAmount.from("10000"));
        assertThat(lottoTicket.getSize()).isEqualTo(10);
    }
}
