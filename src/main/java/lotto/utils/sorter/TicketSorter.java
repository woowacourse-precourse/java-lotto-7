package lotto.utils.sorter;

import lotto.dto.result.IssuedTickets;
import lotto.dto.result.SortedIssuedTickets;

import java.util.List;
import java.util.stream.Collectors;

public class TicketSorter {

    private TicketSorter() {
    }

    public static SortedIssuedTickets getSortedTickets(IssuedTickets issuedTickets) {
        List<List<Integer>> sortedTickets = issuedTickets.issuedTickets().stream()
                .map(winningNumbers -> winningNumbers.lottoNumbers().stream()
                        .sorted()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        return new SortedIssuedTickets(sortedTickets);
    }
}