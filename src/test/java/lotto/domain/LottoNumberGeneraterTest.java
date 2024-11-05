package lotto.domain;

import lotto.domain.LottoNumberGenerater;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoNumberGeneraterTest {

    private LottoNumberGenerater lottoNumberGenerater;

    @BeforeEach
    public void setUp() {
        lottoNumberGenerater = new LottoNumberGenerater();
    }

    @Test
    @DisplayName("로또 번호 생성 개수와 일치하는지 확인")
    public void testGenerateLottoTicketsSize() {
        int numberOfLotto = 5;
        List<List<Integer>> lottoTickets = lottoNumberGenerater.generateLottoTickets(numberOfLotto);
        assertEquals(numberOfLotto, lottoTickets.size(), "생성된 로또 티켓의 개수가 맞아야 합니다.");
    }

    @Test
    @DisplayName("각 로또 티켓의 숫자가 오름차순으로 정렬되었는지 확인")
    public void testEachTicketIsSorted() {
        int numberOfLotto = 5;
        List<List<Integer>> lottoTickets = lottoNumberGenerater.generateLottoTickets(numberOfLotto);

        for (List<Integer> ticket : lottoTickets) {
            assertTrue(isSorted(ticket), "각 로또 티켓의 숫자는 오름차순으로 정렬되어 있어야 합니다.");
        }
    }

    @Test
    @DisplayName("각 로또 티켓의 숫자가 중복되지 않고 6개의 숫자여야 함을 확인")
    public void testEachTicketHasUniqueNumbersAndSize() {
        int numberOfLotto = 5;
        List<List<Integer>> lottoTickets = lottoNumberGenerater.generateLottoTickets(numberOfLotto);

        for (List<Integer> ticket : lottoTickets) {
            assertEquals(6, ticket.size(), "각 로또 티켓은 6개의 숫자를 가져야 합니다.");
            assertEquals(6, ticket.stream().distinct().count(), "각 로또 티켓의 숫자는 중복되지 않아야 합니다.");
        }
    }

    // Helper method to check if a list is sorted in ascending order
    private boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
