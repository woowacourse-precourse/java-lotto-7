package lotto.system.lottoGetter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.system.unit.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketIssuerTest {

    private static final int VALID_PAYMENT = 5000;
    private static final int TICKET_PRICE = 1000;
    private static final int EXPECTED_TICKET_QUANTITY = VALID_PAYMENT / TICKET_PRICE;
    private static final int INVALID_PAYMENT = 750;
    private LottoTicketIssuer issuer;

    @BeforeEach
    void setUp() {
        issuer = new LottoTicketIssuer(VALID_PAYMENT);
    }

    @Test
    @DisplayName("유효한 금액으로 올바른 수량의 로또 티켓 생성 테스트")
    void issueLottoTickets_ShouldGenerateCorrectNumberOfTickets() {
        // when
        List<LottoTicket> tickets = issuer.issueLottoTickets();

        // then : 생성된 티켓 수량이 예상과 일치하는지 확인
        assertEquals(EXPECTED_TICKET_QUANTITY, tickets.size(), "생성된 티켓 수량이 예상과 일치하지 않습니다.");
        verifyTicketNumbers(tickets);
    }

    @Test
    @DisplayName("유효하지 않은 금액으로 예외 발생 테스트")
    void issueLottoTickets_ShouldThrowExceptionForInvalidPayment() {
        // when & then : 유효하지 않은 금액이므로 예외 발생 예상
        assertThrows(IllegalArgumentException.class, () -> new LottoTicketIssuer(INVALID_PAYMENT),
                "유효하지 않은 금액으로 예외가 발생하지 않았습니다.");
    }

    private void verifyTicketNumbers(List<LottoTicket> tickets) {
        // 모든 티켓의 숫자 개수가 6개인지 확인
        tickets.forEach(ticket ->
                assertEquals(6, ticket.getTicket().size(), "로또 티켓의 숫자 개수가 6개가 아닙니다.")
        );
    }
}