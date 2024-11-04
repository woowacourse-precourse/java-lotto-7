package lotto.dto;

import java.util.List;

public record EarnedLotto(List<Integer> numbers) {
    public static EarnedLotto of(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
        return new EarnedLotto(numbers);
    }
}
