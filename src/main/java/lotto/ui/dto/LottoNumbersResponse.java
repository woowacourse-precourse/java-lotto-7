package lotto.ui.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lotto.domain.lotto.LottoNumber;

public class LottoNumbersResponse {

    private final List<Integer> numbers;

    private LottoNumbersResponse(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumbersResponse from(Set<LottoNumber> numbers) {
        return new LottoNumbersResponse(numbers.stream()
                .map(LottoNumber::getNumber)
                .toList());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
