package lotto.service.ticket;

import java.util.List;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.Lottos;
import lotto.repository.ticket.TicketWriteRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TicketWriteService - 티켓 쓰기 서비스")
class TicketWriteServiceTest {
    private Lottos createLottos() {
        return Lottos.of(List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6))
        ));
    }

    @DisplayName("티켓_생성 성공")
    @Test
    void 티켓_생성_성공() {
        // given
        TicketWriteRepository ticketWriteRepository = new TicketWriteRepository();
        TicketIdGenerator ticketIdGenerator = new TicketIdGenerator();
        TicketWriteService ticketWriteService = new TicketWriteService(
                ticketWriteRepository,
                ticketIdGenerator
        );

        Lottos lottos = createLottos();

        // expect
        Assertions.assertThatCode(() -> ticketWriteService.create(lottos))
                .doesNotThrowAnyException();
    }

}
