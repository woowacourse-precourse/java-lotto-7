package lotto.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int REQUIRED_LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateLottoNumberDuplication(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + REQUIRED_LOTTO_NUMBER_COUNT + "개여야 합니다.");
        }
    }

    private void validateLottoNumberDuplication(List<Integer> numbers) {
        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getValue)
                .sorted()
                .toList();
    }
}
