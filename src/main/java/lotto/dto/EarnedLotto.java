package lotto.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record EarnedLotto(List<Integer> numbers) {
    public static EarnedLotto of(List<Integer> numbers) {
        ArrayList<Integer> copiedNumbers = new ArrayList<>(numbers);
        Collections.sort(copiedNumbers);
        return new EarnedLotto(numbers);
    }
}
