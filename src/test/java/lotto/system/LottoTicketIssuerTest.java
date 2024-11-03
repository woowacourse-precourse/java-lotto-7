package lotto.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.system.lottoGetter.LottoTicketIssuer;
import lotto.system.unit.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketIssuerTest {

    @Test
    @DisplayName("유효한 금액을 입력 받아 올바른 수량의 로또 티켓 생성 테스트")
    void issueLottoTickets_ShouldGenerateCorrectNumberOfTickets() {
        // given
        int totalPayment = 5000; // 5장의 티켓을 구매할 수 있는 금액
        int expectedQuantity = totalPayment / 1000;

        // when
        LottoTicketIssuer issuer = new LottoTicketIssuer(totalPayment);
        List<LottoTicket> tickets = issuer.issueLottoTickets();

        // then : 생성된 티켓 수량이 예상과 일치하는지 확인
        assertEquals(expectedQuantity, tickets.size(), "생성된 티켓 수량이 예상과 일치하지 않습니다.");

        // then : 각 티켓의 숫자 개수가 6개인지 확인
        tickets.forEach(ticket -> assertEquals(6, ticket.getTicket().size(), "로또 티켓의 숫자 개수가 6개가 아닙니다."));
    }

    @Test
    @DisplayName("유효하지 않은 금액으로 예외 발생 테스트")
    void issueLottoTickets_ShouldThrowExceptionForInvalidPayment() {
        // given : 티켓 가격의 배수가 아닌 금액
        int invalidPayment = 750;

        // when & then : 예외가 발생 에상
        assertThrows(IllegalArgumentException.class, () -> new LottoTicketIssuer(invalidPayment),
                "유효하지 않은 금액으로 예외가 발생하지 않았습니다.");
    }
}