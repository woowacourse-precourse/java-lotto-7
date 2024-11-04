package lotto.dto;

import java.util.Collections;
import java.util.List;

public record EarnedLotto(List<Integer> numbers) {
    public static EarnedLotto of(List<Integer> numbers) {
        Collections.sort(numbers);
        return new EarnedLotto(numbers);
    }
}
