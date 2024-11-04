package lotto.model;

import lotto.enumerate.Rank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.enumerate.Rank.*;
import static lotto.enumerate.Rank.NONE;

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
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 존재하지 않아야합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public Rank findRank(WinNumber winNumber) {
        int countOfWin = winNumber.countMatchingNumbers(numbers);
        boolean matchBonus = winNumber.isMatchBonus(numbers);
        if (countOfWin == 3) {
            return FIFTH;
        }
        if (countOfWin == 4) {
            return FOURTH;
        }
        if (countOfWin == 5 && !matchBonus) {
            return THIRD;
        }
        if (countOfWin == 5) {
            return SECOND;
        }
        if (countOfWin == 6) {
            return FIRST;
        }
        return NONE;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
