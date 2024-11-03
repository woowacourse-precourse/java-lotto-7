package lotto.converter;

import java.util.List;
import lotto.domain.LottoNumber;

public class StringsToLottoNumbersConverter implements LottoNumbersConverter {

    private final List<String> numbers;

    public StringsToLottoNumbersConverter(List<String> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<LottoNumber> convert() {
        return numbers.stream().map(LottoNumber::new).toList();
    }
}
