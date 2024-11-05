package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class LottoTicketsTest {
    @Test
    @DisplayName("로또 티켓 생성 및 개수 확인 테스트")
    void createLottoTickets() {
        List<Lotto> tickets = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        LottoTickets lottoTickets = LottoTickets.from(tickets);

        assertEquals(2, lottoTickets.size(), "로또 티켓 수가 일치해야 합니다.");
        assertEquals(tickets, lottoTickets.getLottoTickets(), "로또 티켓 목록이 예상과 일치해야 합니다.");
    }

    @Test
    @DisplayName("빈 로또 티켓 리스트 생성 시 예외 발생")
    void emptyLottoTickets() {
        assertThrows(IllegalArgumentException.class, () -> LottoTickets.from(List.of()),
                "빈 로또 티켓 리스트 생성 시 예외가 발생해야 합니다.");
    }
}