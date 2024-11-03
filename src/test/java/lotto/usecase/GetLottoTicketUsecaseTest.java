package lotto.usecase;


import java.util.List;
import lotto.application.ticket.domain.ticket.Lotto;
import lotto.application.ticket.domain.ticket.Lottos;
import lotto.application.ticket.domain.ticket.Ticket;
import lotto.application.ticket.dto.TicketResponse;
import lotto.application.ticket.repository.TicketReadRepository;
import lotto.application.ticket.repository.TicketWriteRepository;
import lotto.application.ticket.service.TicketReadService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("GetLottoTicketUsecase - 로또 티켓 조회 유스케이스")
class GetLottoTicketUsecaseTest {

    private Ticket createTicket(Long id) {
        return Ticket.issue(id, createLottos());
    }

    private Lottos createLottos() {
        return Lottos.of(List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(11, 12, 13, 14, 15, 16))
        ));
    }

    @Test
    @DisplayName("로또 티켓 조회 성공")
    void 로또_티켓_조회_성공() {
        // given
        TicketWriteRepository writeRepository = new TicketWriteRepository();
        TicketReadRepository readRepository = new TicketReadRepository();
        TicketReadService ticketReadService = new TicketReadService(readRepository);
        GetLottoTicketUsecase usecase = new GetLottoTicketUsecase(ticketReadService);

        Ticket ticket = createTicket(1L);
        writeRepository.save(ticket);

        // when
        TicketResponse response = usecase.execute(1L);

        // then
        Assertions.assertThat(response.lottos())
                .hasSize(2)
                .contains(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(11, 12, 13, 14, 15, 16)
                );
    }

}
