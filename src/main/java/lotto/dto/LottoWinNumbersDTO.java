package lotto.dto;

import java.util.List;

public record LottoWinNumbersDTO(
        List<Integer> winNumbers,
        Integer bonusNumber
) {}
