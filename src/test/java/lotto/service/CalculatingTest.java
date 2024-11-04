package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatingTest {
    Ranking ranking = new Ranking();
    Calculating calculating = new Calculating();
    @Test
    void 수익금_계산(){
        LottoTicket ticket = new LottoTicket(3000);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        ticket.addLottoTicket(new Lotto(List.of(1, 2, 3, 8, 9, 10))); //5000
        ticket.addLottoTicket(new Lotto(List.of(4, 5, 6,7 , 9, 10))); //5000
        ticket.addLottoTicket(new Lotto(List.of(1, 2, 3, 4, 9, 10))); //50000

        ranking.matchLotto(ticket, winningLotto);

        double result = calculating.earningRate(ticket);

        assertEquals(result,2000.0);


    }
}
