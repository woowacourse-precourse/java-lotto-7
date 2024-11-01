package lotto.dto;

import java.util.List;

public record TicketResult(
        int count,
        List<List<Integer>> ticket
) {

}
