package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankingTest {
    Ranking ranking = new Ranking();

    @Test
    void 등수_체크_테스트(){
        LottoTicket ticket = new LottoTicket(6000);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        ticket.addLottoTicket(new Lotto(List.of(1,2,3,4,5,6))); //1등
        ticket.addLottoTicket(new Lotto(List.of(1,2,3,4,5,7))); //2등
        ticket.addLottoTicket(new Lotto(List.of(1,2,3,4,5,8))); //3등
        ticket.addLottoTicket(new Lotto(List.of(1,2,3,4,8,9))); //4등
        ticket.addLottoTicket(new Lotto(List.of(1,2,3,8,9,10))); //5등
        ticket.addLottoTicket(new Lotto(List.of(1,2,8,9,10,11))); //LOSE


        ranking.matchLotto(ticket ,winningLotto);
        HashMap<Rank,Integer> results = ticket.getResult();


        assertEquals(results.get(Rank.FIRST),1);
        assertEquals(results.get(Rank.SECOND),1);
        assertEquals(results.get(Rank.THIRD),1);
        assertEquals(results.get(Rank.FOURTH),1);
        assertEquals(results.get(Rank.FIFTH),1);
        assertEquals(results.get(Rank.LOSE),1);
    }

}
