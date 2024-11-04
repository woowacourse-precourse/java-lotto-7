package lotto.domain.dto;

import java.util.List;

public record LottoResult(
        double returnRate,
        List<String> history
) {
}
