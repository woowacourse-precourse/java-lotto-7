package lotto.application.ticket.repository;


import java.util.List;
import java.util.Optional;
import lotto.application.ticket.domain.ticket.Lotto;
import lotto.application.ticket.domain.ticket.Lottos;
import lotto.application.ticket.domain.ticket.Ticket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TicketReadRepository - 티켓 조회 저장소")
class TicketReadRepositoryTest {

    private Ticket createTicket(Long id) {
        return Ticket.issue(id, createLottos());
    }

    private Lottos createLottos() {
        return Lottos.of(List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6))
        ));
    }

    @Test
    @DisplayName("ID로 티켓 조회 성공")
    void ID로_티켓_조회_성공() {
        // given
        TicketWriteRepository writeRepository = new TicketWriteRepository();
        TicketReadRepository readRepository = new TicketReadRepository();
        Ticket ticket = createTicket(1L);
        writeRepository.save(ticket);

        // when
        Optional<Ticket> foundTicket = readRepository.findById(1L);

        // then
        Assertions.assertThat(foundTicket)
                .isPresent()
                .contains(ticket);
    }

    @Test
    @DisplayName("존재하지 않는 ID로 조회시 빈 Optional 반환")
    void 존재하지않는_ID로_조회시_빈_Optional반환() {
        // given
        TicketReadRepository repository = new TicketReadRepository();

        // when
        Optional<Ticket> result = repository.findById(999L);

        // expect
        Assertions.assertThat(result).isEmpty();
    }

}
