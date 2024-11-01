package lotto.converter;

import java.util.List;
import lotto.domain.LottoNumber;

public class IntegersToLottoNumbersConverter implements LottoNumbersConverter {

    private final List<Integer> numbers;

    public IntegersToLottoNumbersConverter(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<LottoNumber> convert() {
        return numbers.stream().map(LottoNumber::new).toList();
    }
}
