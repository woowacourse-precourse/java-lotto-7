package lotto.application.dto;

import lotto.domain.model.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketsDTO {
    private final List<List<Integer>> tickets;

    public LottoTicketsDTO(List<Lotto> lottoTickets) {
        this.tickets = lottoTickets.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getTickets() {
        return tickets;
    }
}
