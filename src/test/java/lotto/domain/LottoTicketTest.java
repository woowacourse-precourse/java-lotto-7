package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    void 로또_티켓_생성_테스트() {
        //given
        int ticketCount  = 10;
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(ticketCount, () -> nums);

        //when
        List<Lotto> ticket = lottoTicket.getLottoTicket();

        //then
        assertEquals(ticket.size(), ticketCount);
    }

    @Test
    void 출력_형태_변환_테스트() {
        //given
        int ticketCount  = 3;
        List<Integer> nums = List.of(6, 5, 4, 3, 2, 1);
        LottoTicket lottoTicket = new LottoTicket(ticketCount, () -> nums);

        //when
        List<String> printFormNumbers = lottoTicket.getPrintFormNumbers();

        //then
        assertEquals(printFormNumbers.size(), 3);
        for (String printFormNumber : printFormNumbers) {
            assertEquals(printFormNumber, "[1, 2, 3, 4, 5, 6]");
        }
    }

    @Test
    void 당첨_결과_반환_테스트() {
        //given
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(1, () -> nums);

        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 20));
        int bonusNumber = 6;

        //when
        Map<Rank, Integer> result = lottoTicket.getResult(winningNumber, bonusNumber);

        //then
        assertEquals(result.get(Rank.FIRST), 0);
        assertEquals(result.get(Rank.SECOND), 1);
        assertEquals(result.get(Rank.THIRD), 0);
        assertEquals(result.get(Rank.FOURTH), 0);
        assertEquals(result.get(Rank.FIFTH), 0);
    }
}