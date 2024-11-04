package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.assertj.core.util.Arrays;

import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = eraseDuplicated(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private List<Integer> eraseDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() < 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        }
        return new ArrayList<>(uniqueNumbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public String printNumbers() {
        Collections.sort(numbers);

        String outputStirng = "";
        for (Integer e : numbers) {
            outputStirng = outputStirng + e + ", ";
        }
        outputStirng = outputStirng.substring(0, outputStirng.length() - 2);
        return '[' + outputStirng + ']';
    }

    public int checkNumber(int bonus) {
        for (Integer e : numbers) {
            if (e == bonus) {
                return 1;
            }
        }
        return 0;
    }
}
