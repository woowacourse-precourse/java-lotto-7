package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {

    public static void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> checker = new HashSet<>();
        numbers
                .forEach(number -> {
                    if (!checker.add(number)) {
                        throw new IllegalArgumentException("[ERROR] 중복된 번호가 있어요.");
                    }
                });
    }
}
