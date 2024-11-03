package lotto.utils.formatter;

import lotto.dto.result.FormattedTickets;
import lotto.dto.result.SortedIssuedTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TicketFormatterTest {

    @Test
    @DisplayName("정렬된 티켓을 형식화하여 문자열 리스트로 변환")
    void formatTickets_테스트() {
        List<List<Integer>> sortedTickets = List.of(
                List.of(3, 5, 7, 12, 18, 25),
                List.of(1, 2, 3, 4, 5, 6)
        );
        SortedIssuedTickets sortedIssuedTickets = new SortedIssuedTickets(sortedTickets);

        FormattedTickets formattedTickets = TicketFormatter.formatTickets(sortedIssuedTickets);

        List<String> expectedFormattedTickets = List.of(
                "[3, 5, 7, 12, 18, 25]",
                "[1, 2, 3, 4, 5, 6]"
        );

        assertThat(formattedTickets.formattedTickets()).isEqualTo(expectedFormattedTickets);
    }
}
