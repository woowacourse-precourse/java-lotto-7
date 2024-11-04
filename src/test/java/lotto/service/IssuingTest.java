package lotto.service;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;
import lotto.domain.Lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IssuingTest {
    Issuing issue = new Issuing();
    @Test
    void 로또_티켓_발급(){
        int count = 6;

        List<Lotto> lottos = issue.lottoTickets(count);

        assertThat(lottos).hasSize(count);
    }


}

