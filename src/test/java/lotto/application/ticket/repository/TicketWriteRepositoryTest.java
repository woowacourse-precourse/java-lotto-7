package lotto.application.ticket.repository;

import java.util.List;
import lotto.application.ticket.domain.ticket.Lotto;
import lotto.application.ticket.domain.ticket.Lottos;
import lotto.application.ticket.domain.ticket.Ticket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TicketWriteRepository - 티켓 저장 저장소")
class TicketWriteRepositoryTest {
    private Ticket createTicket(Long id) {
        return Ticket.issue(id, createLottos());
    }

    private Lottos createLottos() {
        return Lottos.of(List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6))
        ));
    }

    @Test
    @DisplayName("티켓 저장 성공")
    void 티켓_저장_성공() {
        // given
        TicketWriteRepository repository = new TicketWriteRepository();
        Ticket ticket = createTicket(1L);

        // when
        Long savedId = repository.save(ticket);

        // then
        Assertions.assertThat(savedId).isEqualTo(1L);
    }

}
