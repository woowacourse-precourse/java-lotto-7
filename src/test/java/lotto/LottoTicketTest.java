package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {
    @Test
    public void 보너스번호_포함() throws Exception{
        LottoTicket ticket = new LottoTicket(List.of(1,2,3,4,5,6));
        int bonusNumber = 5;
        assertThat(ticket.doesContainBonusNumber(bonusNumber)).isTrue();
    }
    @Test
    public void 보너스번호_미포함() throws Exception{
        LottoTicket ticket = new LottoTicket(List.of(1,2,3,4,5,6));
        int bonusNumber = 6;
        assertThat(ticket.doesContainBonusNumber(bonusNumber)).isTrue();
    }
    @Test
    public void 순위_결정_1등() throws Exception{
        LottoTicket ticket = new LottoTicket(List.of(1,2,3,4,5,6));
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;
        ticket.decideLottoPlaceBy(lotto, bonusNumber);
        assertThat(ticket.getPlace()).isEqualTo(LottoPlace.FIRST);
    }
    @Test
    public void 순위_결정_2등() throws Exception{
        LottoTicket ticket = new LottoTicket(List.of(1,2,3,4,5,7));
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;
        ticket.decideLottoPlaceBy(lotto, bonusNumber);
        assertThat(ticket.getPlace()).isEqualTo(LottoPlace.SECOND);
    }
    @Test
    public void 순위_결정_3등() throws Exception{
        LottoTicket ticket = new LottoTicket(List.of(1,2,3,4,5,8));
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;
        ticket.decideLottoPlaceBy(lotto, bonusNumber);
        assertThat(ticket.getPlace()).isEqualTo(LottoPlace.THIRD);
    }
    @Test
    public void 순위_결정_4등() throws Exception{
        LottoTicket ticket = new LottoTicket(List.of(1,2,3,4,7,8));
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;
        ticket.decideLottoPlaceBy(lotto, bonusNumber);
        assertThat(ticket.getPlace()).isEqualTo(LottoPlace.FORTH);
    }
    @Test
    public void 순위_결정_5등() throws Exception{
        LottoTicket ticket = new LottoTicket(List.of(1,2,3,7,8,9));
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;
        ticket.decideLottoPlaceBy(lotto, bonusNumber);
        assertThat(ticket.getPlace()).isEqualTo(LottoPlace.FIFTH);
    }
    @Test
    public void 순위_결정_탈락() throws Exception{
        LottoTicket ticket = new LottoTicket(List.of(1,2,3,4,5,6));
        Lotto lotto = new Lotto(List.of(7,8,9,10,11,12));
        int bonusNumber = 20;
        ticket.decideLottoPlaceBy(lotto, bonusNumber);
        assertThat(ticket.getPlace()).isEqualTo(LottoPlace.LOSE);
    }
}
