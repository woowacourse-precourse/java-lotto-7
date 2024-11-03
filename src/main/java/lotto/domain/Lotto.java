package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException("중복된 숫자를 포함할 수 없습니다");
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
