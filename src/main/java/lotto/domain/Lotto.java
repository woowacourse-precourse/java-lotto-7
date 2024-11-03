package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = sorted(numbers);
    }

    private void validate(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(numbers);
        if(lottoNumbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복됩니다.");
        }
    }

    private List<LottoNumber> sorted(List<LottoNumber> numbers) {
        return numbers.stream()
                .sorted(Comparator.comparingInt(LottoNumber::lottoNumber))
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}
