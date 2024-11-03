package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
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
}
