package lotto.domain.model;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoTickets;
import lotto.util.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

public class LottoTicketsTest {

    @DisplayName("티켓 리스트가 null일 때 예외가 발생한다.")
    @Test
    void shouldThrowExceptionWhenTicketsAreNull() {
        assertThatThrownBy(() -> new LottoTickets(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.EMPTY_LOTTO_TICKET_LIST);
    }

    @DisplayName("티켓 리스트가 비어 있을 때 예외가 발생한다.")
    @Test
    void shouldThrowExceptionWhenTicketsAreEmpty() {
        assertThatThrownBy(() -> new LottoTickets(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.EMPTY_LOTTO_TICKET_LIST);
    }

    @DisplayName("유효한 티켓 리스트로 객체를 생성할 수 있다.")
    @Test
    void shouldCreateLottoTicketsWithValidTicketList() {
        List<Lotto> validTickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        LottoTickets lottoTickets = new LottoTickets(validTickets);

        assertThat(lottoTickets.getTickets()).isEqualTo(validTickets);
    }

    @DisplayName("동일한 티켓 리스트를 가진 객체는 equals 비교 시 동일하다.")
    @Test
    void shouldBeEqualWhenLottoTicketsHaveSameList() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        LottoTickets lottoTickets1 = new LottoTickets(tickets);
        LottoTickets lottoTickets2 = new LottoTickets(tickets);

        assertThat(lottoTickets1).isEqualTo(lottoTickets2);
    }
}
