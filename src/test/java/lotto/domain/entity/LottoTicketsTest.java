package lotto.domain.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @Test
    void 로또들의_리스트를_가지고_있는_컬렉션_생성() {
        // given
        final Lotto lottoEx1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto lottoEx2 = new Lotto(List.of(11, 12, 13, 14, 15, 16, 17));
        final Lotto lottoEx3 = new Lotto(List.of(21, 22, 23, 24, 25, 26, 27));

        // when
        final LottoTickets tickets = new LottoTickets(List.of(lottoEx1, lottoEx2, lottoEx3));

        // then
        assertThat(tickets.getTickets().size()).isEqualTo(3);
    }
}