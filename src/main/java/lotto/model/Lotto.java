package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.ErrorMessages;
import lotto.utils.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return new Lotto(numbers);
    }

    public LottoRank getRank(Lotto winNumbers, int bonusNumber) {
        int countOfMatch = countOfMatch(winNumbers);
        boolean containsBonusNumber = containsBonusNumber(bonusNumber);

        return LottoRank.valueOf(countOfMatch, containsBonusNumber);
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private int countOfMatch(Lotto lotto) {
        return (int) lotto.numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    private void validate(List<Integer> numbers) {
        validateNumberRange(numbers);
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new LottoException(ErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new LottoException(ErrorMessages.LOTTO_NUMBER_DUPLICATED);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(ErrorMessages.LOTTO_NUMBER_SIZE);
        }
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
