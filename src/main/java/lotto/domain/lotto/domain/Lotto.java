package lotto.domain.lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = convertToLottoNumbers(numbers);
    }

    private List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    /**
     * Validate 함수
     * @param numbers
     */

    private void validate(List<Integer> numbers) {
        checkLength(numbers);
        checkDuplicates(numbers);
    }

    private void checkLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void checkDuplicates(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        if (numbers.size() != checkNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 있습니다.");
        }
    }

}
