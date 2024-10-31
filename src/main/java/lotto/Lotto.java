package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
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
    // TODO: 추가 기능 구현
}
