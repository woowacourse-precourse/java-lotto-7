package lotto.dto;

import java.util.List;

public record LottoGradingNumbersDTO(
        List<Integer> winNumbers,
        Integer bonusNumber
) {}
