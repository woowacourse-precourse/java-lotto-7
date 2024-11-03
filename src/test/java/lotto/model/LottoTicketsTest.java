package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    private Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private LottoTicket createLottoTicket(Lotto lotto, Money price) {
        return new LottoTicket(lotto, price);
    }

    private LottoTickets createLottoTickets(List<LottoTicket> tickets) {
        return new LottoTickets(tickets);
    }

    @DisplayName("LottoTickets을 생성할 수 있다.")
    @Test
    void LottoTickets_생성() {
        Lotto lotto1 = createLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = createLotto(List.of(7, 8, 9, 10, 11, 12));
        Money price1 = Money.of(1000);
        Money price2 = Money.of(1000);

        LottoTicket ticket1 = createLottoTicket(lotto1, price1);
        LottoTicket ticket2 = createLottoTicket(lotto2, price2);

        List<LottoTicket> tickets = List.of(ticket1, ticket2);

        LottoTickets lottoTickets = createLottoTickets(tickets);

        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets.tickets()).isEqualTo(tickets);
        assertThat(lottoTickets.totalPrice()).isEqualTo(price1.plus(price2));
    }

    @DisplayName("빈 티켓 리스트로 LottoTickets를 생성할 수 있다.")
    @Test
    void 빈_티켓으로_LottoTickets_생성() {
        List<LottoTicket> emptyTickets = List.of();

        LottoTickets lottoTickets = createLottoTickets(emptyTickets);

        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets.totalPrice()).isEqualTo(Money.of(0));
    }

    @DisplayName("티켓 가격 합계가 올바르게 계산된다.")
    @Test
    void 티켓_가격_합계_계산() {
        Lotto lotto1 = createLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = createLotto(List.of(7, 8, 9, 10, 11, 12));
        Money price1 = Money.of(1000);
        Money price2 = Money.of(2000);

        LottoTicket ticket1 = createLottoTicket(lotto1, price1);
        LottoTicket ticket2 = createLottoTicket(lotto2, price2);

        List<LottoTicket> tickets = List.of(ticket1, ticket2);

        LottoTickets lottoTickets = createLottoTickets(tickets);

        assertThat(lottoTickets.totalPrice()).isEqualTo(price1.plus(price2));
    }

    @DisplayName("toString() 메소드가 모든 티켓의 문자열을 반환한다.")
    @Test
    void toString_테스트() {
        Lotto lotto1 = createLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = createLotto(List.of(7, 8, 9, 10, 11, 12));
        Money price1 = Money.of(1000);
        Money price2 = Money.of(1000);

        LottoTicket ticket1 = createLottoTicket(lotto1, price1);
        LottoTicket ticket2 = createLottoTicket(lotto2, price2);

        List<LottoTicket> tickets = List.of(ticket1, ticket2);

        LottoTickets lottoTickets = createLottoTickets(tickets);

        String expectedString = ticket1 + "\n" + ticket2;
        assertThat(lottoTickets.toString()).isEqualTo(expectedString);
    }
}
