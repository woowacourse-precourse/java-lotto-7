package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketGroupTest {

    private LottoTicketGroup lottoTicketGroup;

    @BeforeEach
    public void setUp() {
        lottoTicketGroup = new LottoTicketGroup();
    }

    @DisplayName("여러장의 로또 티켓들의 값들이 잘 저장되고있는지 확인한다.")
    @Test
    public void 여러장의_로또티켓들의_값들이_잘_저장되고있는지_테스트() {
        //given
        List<Integer> lottoNumbers1 = Arrays.asList(5, 6, 7, 8, 9, 20);
        Lotto lotto1 = new Lotto(lottoNumbers1);
        LottoTicket ticket1 = new LottoTicket(lotto1);

        List<Integer> lottoNumbers2 = Arrays.asList(5, 6, 7, 8, 9, 20);
        Lotto lotto2 = new Lotto(lottoNumbers2);
        LottoTicket ticket2 = new LottoTicket(lotto2);

        //when
        lottoTicketGroup.addTicket(ticket1);
        lottoTicketGroup.addTicket(ticket2);

        //then
        assertEquals(2, lottoTicketGroup.getTickets().size());
        assertEquals(ticket1, lottoTicketGroup.getTickets().get(0));
        assertEquals(ticket2, lottoTicketGroup.getTickets().get(1));
    }
}
