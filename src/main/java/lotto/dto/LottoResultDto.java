package lotto.dto;

import java.util.Map;

public record LottoResultDto(
        Map<Integer, Integer> result,
        double revenue
) {
}
