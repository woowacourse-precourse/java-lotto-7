package lotto.dto.response;

import java.util.List;

public record TicketResponse(
        List<List<Integer>> tickets) {
    public static TicketResponse from(List<List<Integer>> tickets) {
        return new TicketResponse(tickets);
    }
}
