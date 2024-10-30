package lotto;

import java.util.Collections;
import java.util.List;

public class DuplicateValidator {

    public static void validateDuplicate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) > 1) {
                throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 있습니다.");
            }
        }
    }

    public static void validatedNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
