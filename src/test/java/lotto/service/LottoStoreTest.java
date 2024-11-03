package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoStoreTest {
    private final LottoStore lottoStore = new LottoStore();
    @Test
    @DisplayName("유효한 금액에 따른 티켓 수 계산")
    void calculateLottoCountWithValidAmount() {
        assertEquals(5, lottoStore.calculateLottoCount(5000));
        assertEquals(10, lottoStore.calculateLottoCount(10000));
        assertEquals(0, lottoStore.calculateLottoCount(0));
    }

    @Test
    @DisplayName("로또 티켓 생성 시 지정된 수만큼의 티켓이 생성되는지 확인")
    void generateLottoTickets() {
        LottoTickets tickets = lottoStore.generateLottoTickets(5);
        assertEquals(5, tickets.size());

        for (Lotto lotto : tickets.getLottoTickets()) {
            assertEquals(6, lotto.getNumbers().size());
            assertTrue(lotto.getNumbers().stream().allMatch(num -> num >= 1 && num <= 45));
        }
    }


}