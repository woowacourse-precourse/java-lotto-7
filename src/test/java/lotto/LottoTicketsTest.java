package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketsTest {
    private LottoTickets lottoTickets;
    private Lotto lotto;
    private int bonusNumber;
    @BeforeEach
    public void init(){
        LottoTicket ticket1 = new LottoTicket(List.of(1,2,3,4,5,6));
        LottoTicket ticket2 = new LottoTicket(List.of(1,2,3,4,5,6));

        LottoTicket ticket3 = new LottoTicket(List.of(7,2,3,4,5,6));
        LottoTicket ticket4 = new LottoTicket(List.of(1,2,3,4,5,7));
        LottoTicket ticket5 = new LottoTicket(List.of(1,2,3,7,5,6));

        LottoTicket ticket6 = new LottoTicket(List.of(8,2,3,4,5,6));
        LottoTicket ticket7 = new LottoTicket(List.of(1,8,3,4,5,6));

        LottoTicket ticket8 = new LottoTicket(List.of(1,2,3,4,8,9));

        LottoTicket ticket9 = new LottoTicket(List.of(1,2,3,10,11,12));

        LottoTicket ticket10 = new LottoTicket(List.of(20, 21, 22, 23, 24, 25));

        lotto = new Lotto(List.of(1,2,3,4,5,6));
        bonusNumber = 7;
        List<LottoTicket> list = Arrays.asList(ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10);
        lottoTickets = new LottoTickets(list);
    }
    @Test
    public void 최종_결과_계산() throws Exception{
        lottoTickets.decideLottoPlacesBy(lotto, bonusNumber);
        Map<LottoPlace, Integer> table = lottoTickets.getLottoResultSummary();

        assertThat(table.get(LottoPlace.FIRST)).isEqualTo(2);
        assertThat(table.get(LottoPlace.SECOND)).isEqualTo(3);
        assertThat(table.get(LottoPlace.THIRD)).isEqualTo(2);
        assertThat(table.get(LottoPlace.FORTH)).isEqualTo(1);
        assertThat(table.get(LottoPlace.FIFTH)).isEqualTo(1);
        assertThat(table.get(LottoPlace.LOSE)).isEqualTo(1);

        double profitRate = lottoTickets.getProfitRate();
        assertThat(profitRate).isEqualTo(40930550.0);
    }

}
