package lotto.dto;

import java.util.List;

public class LottoTicketsDto {
    private final List<List<Integer>> tickets;

    private LottoTicketsDto(List<List<Integer>> tickets) {
        this.tickets = tickets;
    }

    public static LottoTicketsDto from(List<List<Integer>> tickets) {
        return new LottoTicketsDto(tickets);
    }

    public List<List<Integer>> getTickets() {
        return List.copyOf(tickets);
    }
}
