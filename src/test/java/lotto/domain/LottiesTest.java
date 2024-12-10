package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottiesTest {

    Lotties lottos;

    @BeforeEach
    void setUp() {
        lottos = Lotties.of(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                        new Lotto(List.of(3, 4, 5, 6, 7, 8))
                )
        );
    }

    @DisplayName("동일한 로또를 갖는 컬렉션을 반환한다.")
    @Test
    void of() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto lotto3 = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        Lotties lottos = Lotties.of(
                List.of(lotto1, lotto2, lotto3)
        );

        assertEquals(lotto1, lottos.getLottoTickets().get(0));
        assertEquals(lotto2, lottos.getLottoTickets().get(1));
        assertEquals(lotto3, lottos.getLottoTickets().get(2));

    }

    @DisplayName("수정 불가능한 로또 티켓 컬렉션을 반환한다.")
    @Test
    void getLottoTickets() {
        List<Lotto> lottoTickets = lottos.getLottoTickets();
        assertThrows(UnsupportedOperationException.class, () -> lottoTickets.remove(1));
    }

    @DisplayName("정확한 로또 갯수를 반환한다.")
    @Test
    void size() {
        assertEquals(3, lottos.size());
    }
}