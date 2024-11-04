package lotto.domain.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.dto.result.IssuedTickets;
import lotto.dto.result.TicketCount;
import lotto.dto.result.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class TicketIssuerTest {

    private TicketCount ticketCount;
    private TicketIssuer ticketIssuer;

    @BeforeEach
    void setUp() {
        ticketCount = new TicketCount(5);
        ticketIssuer = new TicketIssuer(ticketCount);
    }

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("발행된 티켓 수가 요청한 티켓 수와 일치하는지 확인")
        void 발행된_티켓_수가_일치하는지_확인() {
            IssuedTickets issuedTickets = ticketIssuer.issueTickets();

            assertEquals(ticketCount.count(), issuedTickets.issuedTickets().size(),
                    "발행된 티켓 수가 요청한 티켓 수와 일치해야 합니다.");
        }

        @Test
        @DisplayName("발행된 각 티켓이 올바른 형식인지 확인")
        void 발행된_티켓_형식_확인() {
            IssuedTickets issuedTickets = ticketIssuer.issueTickets();

            for (WinningNumbers winningNumbers : issuedTickets.issuedTickets()) {
                assertThat(winningNumbers.lottoNumbers()).hasSize(6);
                assertThat(winningNumbers.lottoNumbers()).allMatch(number -> number >= 1 && number <= 45);
                assertThat(new HashSet<>(winningNumbers.lottoNumbers()).size())
                        .isEqualTo(winningNumbers.lottoNumbers().size());
            }
        }
    }
}
