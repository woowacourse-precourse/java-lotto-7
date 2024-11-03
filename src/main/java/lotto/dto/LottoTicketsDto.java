package lotto.dto;

import java.util.List;

public record LottoTicketsDto(
        int purchaseCount,
        List<List<Integer>> lottoNumbers
) {
}
