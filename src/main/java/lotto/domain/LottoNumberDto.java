package lotto.domain;

import java.util.List;

public record LottoNumberDto(List<Integer> numbers) {

    public static LottoNumberDto of(final List<LottoNumber> numbers) {
        return new LottoNumberDto(numbers.stream()
                .map(LottoNumber::getNumber)
                .toList());
    }
}
