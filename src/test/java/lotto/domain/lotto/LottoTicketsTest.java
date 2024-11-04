package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @DisplayName("번호를 넣으면 해당 번호로 로또를 발행해 저장한다.")
    @Test
    void 번호를_넣으면_로또를_발행해_저장() {
        LottoTickets lottoTickets = new LottoTickets();

        lottoTickets.save(Lotto.issue(List.of(1, 2, 3, 4, 5, 6)));

        assertThat(lottoTickets.findAll()).hasSize(1);
    }

}
