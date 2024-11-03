package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_LENGTH.get());
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.get());
            }
        }
    }

    public List<Integer> get() {
        return Collections.unmodifiableList(numbers);
    }

    public LottoPrize compareNumber(Lotto winningLotto, int bonusNumber) {
        List<Integer> commonElements = new ArrayList<>(numbers);
        commonElements.retainAll(winningLotto.get());

        int matchingCount = commonElements.size();
        boolean hasBonus = matchingCount == 5 && numbers.contains(bonusNumber);

        return LottoPrize.findPrize(matchingCount, hasBonus);
    }
}
