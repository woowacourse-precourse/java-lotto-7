package lotto.system.formater;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.system.lottoGetter.LottoTicketIssuer;
import lotto.system.unit.LottoTicket;
import lotto.user.Bonus;
import lotto.user.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrintFormatterTest {

    private PrintFormatter printFormatter;

    @BeforeEach
    void setUp() {
        printFormatter = new PrintFormatter();
    }

    @DisplayName("로또 티켓과 개수 출력 테스트")
    @Test
    void displayLottoTicketsWithQuantityTest() {
        List<LottoTicket> tickets = List.of(
                LottoTicket.ofRawNumbers(List.of(1, 2, 3, 4, 5, 6)));
        printFormatter.displayLottoTicketsWithQuantity(tickets, tickets.size());
        assertThat(tickets).isNotEmpty();
    }

    @DisplayName("결과 출력 테스트")
    @Test
    void displayResultWithNewLineTest() {
        String result = "테스트 결과";
        printFormatter.displayResultWithNewLine(result);
        assertThat(result).isEqualTo("테스트 결과");
    }
}