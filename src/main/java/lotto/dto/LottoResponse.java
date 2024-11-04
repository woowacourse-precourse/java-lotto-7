package lotto.dto;

import lotto.model.Lotto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public record LottoResponse(
        List<String> lottoNumber
) {
    public static LottoResponse from(Lotto lotto) {
        List<String> stringLottoNumber = lotto.getNumbers().stream()
                .map(String::valueOf)
                .sorted(Comparator.comparingInt(Integer::parseInt))
                .collect(Collectors.toList());

        return new LottoResponse(stringLottoNumber);
    }
}
