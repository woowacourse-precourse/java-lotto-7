package lotto.service;

import lotto.evaluator.LottoEvaluator;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    @Test
    @DisplayName("여러 장의 로또 티켓 생성")
    void 여러장_로또_티켓_생성() {
        // given
        LottoTicketGenerator ticketGenerator = new LottoTicketGenerator();
        LottoEvaluator lottoEvaluator = new LottoEvaluator();
        LottoService lottoService = new LottoService(ticketGenerator, lottoEvaluator);

        // when
        List<Lotto> lottoTickets = lottoService.generateLottoTickets(5);

        // then
        assertThat(lottoTickets).hasSize(5);
        lottoTickets.forEach(lotto -> assertThat(lotto.getNumbers()).hasSize(6));
    }
}
