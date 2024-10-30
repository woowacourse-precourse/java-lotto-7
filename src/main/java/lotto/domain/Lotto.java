package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class Lotto {
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> i_numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(i_numbers.stream().map(LottoNumber::new).toList());
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
