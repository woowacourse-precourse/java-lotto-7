package lotto.usecase;

import lotto.domain.common.ThousandWons.ThousandWons;
import lotto.repository.paymnet.PaymentWriteRepository;
import lotto.repository.ticket.TicketWriteRepository;
import lotto.service.payment.PaymentIdGenerator;
import lotto.service.payment.PaymentWriteService;
import lotto.service.ticket.LottoWriteService;
import lotto.service.ticket.NumberGenerator;
import lotto.service.ticket.TicketIdGenerator;
import lotto.service.ticket.TicketWriteService;
import lotto.service.ticket.UniqueNumberGenerator;
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
