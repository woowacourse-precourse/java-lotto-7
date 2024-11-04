package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket();
    }

    @Test
    @DisplayName("addLotto 메서드가 정상 작동하여 로또가 추가되는지 테스트")
    void shouldAddLottoToLottoTicket() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        lottoTicket.addLotto(lotto);

        assertEquals(1, lottoTicket.getLottos().size(), "로또 추가 후 로또 개수가 올바르지 않습니다.");
        assertTrue(lottoTicket.getLottos().contains(lotto), "추가된 로또가 리스트에 포함되지 않았습니다.");
    }

    @Test
    @DisplayName("getLottos 메서드가 올바른 리스트를 반환하는지 테스트")
    void shouldReturnListOfLottos() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        lottoTicket.addLotto(lotto1);
        lottoTicket.addLotto(lotto2);

        List<Lotto> lottos = lottoTicket.getLottos();

        assertEquals(2, lottos.size(), "로또 티켓의 로또 리스트 개수가 올바르지 않습니다.");
        assertTrue(lottos.contains(lotto1), "첫 번째 로또가 리스트에 포함되지 않았습니다.");
        assertTrue(lottos.contains(lotto2), "두 번째 로또가 리스트에 포함되지 않았습니다.");
    }
}
