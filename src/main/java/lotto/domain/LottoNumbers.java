package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LottoNumbers {
    static final int NUMBERS_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    LottoNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }
        Set<LottoNumber> lottoNumbers = new HashSet<>(numbers.stream().map(LottoNumber::new).toList());
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    Stream<LottoNumber> filter(Predicate<LottoNumber> predicate) {
        return lottoNumbers.stream().filter(predicate);
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
