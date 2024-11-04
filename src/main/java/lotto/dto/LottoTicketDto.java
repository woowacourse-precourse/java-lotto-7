package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.lotto.LottoTickets;
import lotto.model.draw.LottoNumbersGenerator;

public record LottoTicketDto(int totalTickets, List<List<Integer>> tickets) {
    public static LottoTicketDto from(LottoTickets lottoTickets) {
        List<LottoNumbersGenerator> generators = lottoTickets.getLottoTickets();
        return new LottoTicketDto(
                generators.size(),
                convertToNumbersList(generators)
        );
    }

    private static List<List<Integer>> convertToNumbersList(List<LottoNumbersGenerator> generators) {
        return generators.stream()
                .map(LottoNumbersGenerator::getLottoNumbers)
                .collect(Collectors.toList());
    }
}