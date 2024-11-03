package lotto.usecase;

import lotto.application.common.ThousandWons.ThousandWons;
import lotto.application.prize.repository.paymnet.PaymentWriteRepository;
import lotto.application.ticket.repository.TicketWriteRepository;
import lotto.application.ticket.service.LottoWriteService;
import lotto.application.ticket.service.NumberGenerator;
import lotto.application.ticket.service.TicketIdGenerator;
import lotto.application.ticket.service.TicketWriteService;
import lotto.application.ticket.service.UniqueNumberGenerator;
import lotto.application.ticket.service.payment.PaymentIdGenerator;
import lotto.application.ticket.service.payment.PaymentWriteService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CreateLottoTicketUsecase - 로또 티켓 생성 유스케이스")
class CreateLottoTicketUsecaseTest {

    private PaymentWriteService createPaymentWriteService() {
        PaymentWriteRepository paymentRepository = new PaymentWriteRepository();
        PaymentIdGenerator idGenerator = new PaymentIdGenerator();
        return new PaymentWriteService(paymentRepository, idGenerator);
    }

    private LottoWriteService createLottoWriteService() {
        NumberGenerator numberGenerator = new UniqueNumberGenerator();
        return new LottoWriteService(numberGenerator);
    }

    private TicketWriteService createTicketWriteService() {
        TicketWriteRepository repository = new TicketWriteRepository();
        TicketIdGenerator idGenerator = new TicketIdGenerator();
        return new TicketWriteService(repository, idGenerator);
    }


    @Test
    @DisplayName("로또 티켓 생성 성공")
    void 로또_티켓_생성_성공() {
        // given
        PaymentWriteService paymentWriteService = createPaymentWriteService();
        LottoWriteService lottoWriteService = createLottoWriteService();
        TicketWriteService ticketWriteService = createTicketWriteService();

        CreateLottoTicketUsecase usecase = new CreateLottoTicketUsecase(
                paymentWriteService,
                lottoWriteService,
                ticketWriteService
        );

        ThousandWons money = ThousandWons.of("5000");

        // when
        Long ticketId = usecase.execute(money);

        // then
        Assertions.assertThat(ticketId).isNotNull();
    }
}
