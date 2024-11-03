package lotto.dto;

import java.util.List;
import lotto.domain.lotto.LottoNumber;

public record LottoNumberDto(List<Integer> numbers) {

    public static LottoNumberDto of(final List<LottoNumber> numbers) {
        return new LottoNumberDto(numbers.stream()
                .map(LottoNumber::getNumber)
                .toList());
    }
}
