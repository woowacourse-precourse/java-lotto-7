package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.sort;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.");
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 값만 가능 합니다.");
            }
        }
    }

    public boolean isBonusBallMatch(Integer bonusBall) {
        return numbers.contains(bonusBall);
    }

    public int getCorrectCount(Lotto winner) {
        int count = 0;
        for (Integer number : numbers) {
            if (winner.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public String numbersToString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
