package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

class LottosTest {

    @Test
    void Lottos_객체가_로또_티켓_목록을_정상적으로_저장한다() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        List<Lotto> tickets = List.of(lotto1, lotto2);

        // when
        Lottos lottos = new Lottos(tickets);

        // then
        assertThat(lottos.getTickets()).containsExactly(lotto1, lotto2);
    }

    @Test
    void Lottos_객체가_빈_로또_티켓_목록일_경우_예외가_발생한다() {
        // given
        List<Lotto> emptyTickets = List.of();

        // when // then
        assertThatThrownBy(() -> new Lottos(emptyTickets))
                .isInstanceOf(LottoException.class)
                .hasMessage("[ERROR] 로또 목록은 비어 있을 수 없습니다. 티켓을 추가해 주세요.");
    }
}
