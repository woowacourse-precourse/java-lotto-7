package lotto.domain.number;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
    static final int NUMBERS_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(numbers.stream().map(LottoNumber::new).toList());
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
