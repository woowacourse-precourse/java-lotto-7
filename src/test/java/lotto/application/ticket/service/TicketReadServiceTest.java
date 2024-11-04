package lotto.application.ticket.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.application.ticket.domain.ticket.Lotto;
import lotto.application.ticket.domain.ticket.Lottos;
import lotto.application.ticket.domain.ticket.Ticket;
import lotto.application.ticket.dto.TicketResponse;
import lotto.application.ticket.repository.TicketCommonStorage;
import lotto.application.ticket.repository.TicketReadRepository;
import lotto.application.ticket.repository.TicketWriteRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoReadService - 로또 조회 서비스")
class TicketReadServiceTest {

    @BeforeEach
    void setUp() {
        TicketCommonStorage.clear();
    }


    private Ticket createTicket(Long id) {
        return Ticket.issue(id, createLottos());
    }

    private Lottos createLottos() {
        return Lottos.of(List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6))
        ));
    }


    @DisplayName("티켓 Id로 티켓 조회 성공")
    @Test
    void 티켓_Id로_티켓_조회_성공() {
        // given
        TicketWriteRepository ticketWriteRepository = new TicketWriteRepository();
        TicketReadRepository ticketReadRepository = new TicketReadRepository();
        TicketReadService ticketReadService = new TicketReadService(ticketReadRepository);

        Ticket ticket = createTicket(1L);

        Long saveId = ticketWriteRepository.save(ticket);
        // when
        TicketResponse response = ticketReadService.getTicket(1L);
        response.lottos();

        // then
        assertThat(response.lottosSize()).isEqualTo(ticket.getLottosSize());
    }

    @DisplayName("없는 티켓Id로 조회 실패")
    @Test
    void 없는_티켓Id로_조회_실패() {
        // given
        TicketReadRepository ticketReadRepository = new TicketReadRepository();
        TicketReadService ticketReadService = new TicketReadService(ticketReadRepository);

        // expect
        Assertions.assertThatThrownBy(() -> ticketReadService.getTicket(1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 존재 하지 않는 티켓 ID 입니다.");
    }

}
