package lotto.utils.sorter;

import lotto.dto.result.IssuedTickets;
import lotto.dto.result.SortedIssuedTickets;
import lotto.dto.result.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TicketSorterTest {

    @Test
    @DisplayName("발행된 티켓을 올바르게 정렬하여 반환하는지 확인")
    void 티켓_정렬_테스트() {
        List<WinningNumbers> issuedTicketsList = List.of(
                new WinningNumbers(List.of(23, 5, 32, 16, 3, 11)),
                new WinningNumbers(List.of(43, 42, 21, 8, 23, 41)),
                new WinningNumbers(List.of(14, 3, 1, 5, 45, 22))
        );
        IssuedTickets issuedTickets = new IssuedTickets(issuedTicketsList);

        SortedIssuedTickets sortedIssuedTickets = TicketSorter.getSortedTickets(issuedTickets);

        List<List<Integer>> expectedSortedTickets = List.of(
                List.of(3, 5, 11, 16, 23, 32),
                List.of(8, 21, 23, 41, 42, 43),
                List.of(1, 3, 5, 14, 22, 45)
        );
        assertThat(sortedIssuedTickets.sortedTickets()).isEqualTo(expectedSortedTickets);
    }
}
