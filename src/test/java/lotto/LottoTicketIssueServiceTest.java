package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.service.LottoNumberGeneratorService;
import lotto.service.LottoTicketIssueService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketIssueServiceTest {
    @DisplayName("지정된 로또 티켓 수만큼 로또를 발행한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 15})
    void 지정된_로또_티켓_수만큼_로또를_발행한다(Integer lottoTicketAmount) {
        LottoTicketIssueService lottoTicketIssueService = new LottoTicketIssueService(lottoTicketAmount,
                new LottoNumberGeneratorService());

        List<Lotto> lottoList = lottoTicketIssueService.issueLotto();

        assertThat(lottoList.size()).isEqualTo(lottoTicketAmount);
    }

}
