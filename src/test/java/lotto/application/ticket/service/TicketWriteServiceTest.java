package lotto.application.ticket.service;

import java.util.List;
import lotto.application.ticket.domain.payment.LottoQuantity;
import lotto.application.ticket.domain.ticket.Lotto;
import lotto.application.ticket.domain.ticket.Lottos;
import lotto.application.ticket.repository.TicketWriteRepository;
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
        NumberGenerator numberGenerator = new UniqueNumberGenerator();
        LottoWriteService lottoWriteService = new LottoWriteService(numberGenerator);

        TicketWriteService ticketWriteService = new TicketWriteService(
                ticketWriteRepository,
                lottoWriteService,
                ticketIdGenerator
        );

        LottoQuantity quantity = LottoQuantity.of(3);

        // expect
        Assertions.assertThatCode(() -> ticketWriteService.create(quantity))
                .doesNotThrowAnyException();
    }

}
