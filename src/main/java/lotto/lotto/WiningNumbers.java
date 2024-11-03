package lotto.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WiningNumbers {

    private static final int MAX_WINNING_NUMBERS = 6;

    private final List<LottoNumber> numbers;

    public WiningNumbers(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateLottoNumberDuplication(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    public int countOfMatch(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != MAX_WINNING_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수는 " + MAX_WINNING_NUMBERS + "개여야 합니다.");
        }
    }

    private void validateLottoNumberDuplication(List<Integer> numbers) {
        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }
}
