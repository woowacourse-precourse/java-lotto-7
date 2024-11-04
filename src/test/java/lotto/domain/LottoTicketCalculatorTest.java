package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class LottoTicketCalculatorTest {

    private final LottoTicketCalculator lottoTicketCalculator = new LottoTicketCalculator();

    @DisplayName("입력한 금액만큼 로또 수량 계산하는 기능 테스트")
    @Test
    void 입력단위가_1000단위_값이_들어온_경우() {
        assertThat(lottoTicketCalculator.getLottoTicketsCount("1000")).isEqualTo(1);
        assertThat(lottoTicketCalculator.getLottoTicketsCount("5000")).isEqualTo(5);
        assertThat(lottoTicketCalculator.getLottoTicketsCount("33000")).isEqualTo(33); // Should truncate
        assertThat(lottoTicketCalculator.getLottoTicketsCount("1001000")).isEqualTo(1001);  // Less than one ticket
    }
}
