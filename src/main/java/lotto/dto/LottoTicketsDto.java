package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public record LottoTicketsDto(
        int purchaseCount,
        List<List<Integer>> lottoNumbers
) {
    public static LottoTicketsDto from(List<Lotto> tickets) {
        List<List<Integer>> lottoNumbers = tickets.stream()
                .map(Lotto::getNumbers)
                .toList();

        return new LottoTicketsDto(tickets.size(), lottoNumbers);
    }
}
