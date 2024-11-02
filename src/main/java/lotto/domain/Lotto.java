package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
            .map(LottoNumber::new)
            .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateUnique(List<Integer> lottoNumbers) {
        if (containsDuplicates(lottoNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private boolean containsDuplicates(List<Integer> lottoNumbers) {
        return new HashSet<>(lottoNumbers).size() != lottoNumbers.size();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .toList();
    }
}
