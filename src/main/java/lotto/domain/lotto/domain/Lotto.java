package lotto.domain.lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = convertToLottoNumbers(numbers);
    }

    public static Lotto from(
            final List<Integer> numbers
    ) {
        return new Lotto(numbers);
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
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void checkDuplicates(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        if (numbers.size() != checkNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 있습니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
