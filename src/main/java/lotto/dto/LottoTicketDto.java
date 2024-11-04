package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.lotto.LottoTickets;
import lotto.model.draw.LottoNumbersGenerator;

public record LottoTicketDto(int totalTickets, List<List<Integer>> tickets) {
    public static LottoTicketDto from(LottoTickets lottoTickets) {
        return new LottoTicketDto(
                lottoTickets.getLottoTickets().size(),
                lottoTickets.getLottoTickets().stream()
                        .map(LottoNumbersGenerator::getLottoNumbers)
                        .collect(Collectors.toList())
        );
    }
}