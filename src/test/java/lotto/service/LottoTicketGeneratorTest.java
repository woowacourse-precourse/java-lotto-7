package lotto.service;

import lotto.constants.LottoConstants;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketGeneratorTest {

    private final LottoTicketGenerator ticketGenerator = new LottoTicketGenerator();

    @Test
    @DisplayName("단일 로또 티켓 생성")
    void 단일_로또_티켓_생성() {
        // when
        Lotto ticket = ticketGenerator.generateLottoTicket();

        // then
        assertThat(ticket.getNumbers()).hasSize(LottoConstants.REQUIRED_LOTTO_NUMBERS);
        assertThat(ticket.getNumbers()).allMatch(number -> number >= LottoConstants.MIN_LOTTO_NUMBER && number <= LottoConstants.MAX_LOTTO_NUMBER);
        assertThat(ticket.getNumbers()).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("여러 개의 로또 티켓 생성")
    void 여러개_로또_티켓_생성() {
        // given
        int ticketCount = 5;

        // when
        List<Lotto> tickets = ticketGenerator.generateMultipleLottoTickets(ticketCount);

        // then
        assertThat(tickets).hasSize(ticketCount);
        tickets.forEach(ticket -> {
            assertThat(ticket.getNumbers()).hasSize(LottoConstants.REQUIRED_LOTTO_NUMBERS);
            assertThat(ticket.getNumbers()).allMatch(number -> number >= LottoConstants.MIN_LOTTO_NUMBER && number <= LottoConstants.MAX_LOTTO_NUMBER);
            assertThat(ticket.getNumbers()).doesNotHaveDuplicates();
        });
    }
}

