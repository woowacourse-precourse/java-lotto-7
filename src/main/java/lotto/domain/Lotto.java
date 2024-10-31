package lotto.domain;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    Lotto(List<Integer> numbers) {
        this.lottoNumbers = new LottoNumbers(numbers);
    }

    int getFilteredCount(Predicate<LottoNumber> predicate) {
        return (int) lottoNumbers.filter(predicate).count();
    }
}

