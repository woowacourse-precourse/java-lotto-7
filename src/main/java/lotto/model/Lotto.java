package lotto.model;

import lotto.enumerate.Rank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.enumerate.ErrorPrint.LOTTO_DOES_NOT_ALLOW_DUPLICATE_NUMBER;
import static lotto.enumerate.ErrorPrint.LOTTO_DOES_NOT_HAVE_CORRECT_SIZE;
import static lotto.enumerate.Rank.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_DOES_NOT_HAVE_CORRECT_SIZE.getMsg());
        }
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_DOES_NOT_ALLOW_DUPLICATE_NUMBER.getMsg());
        }
    }

    // TODO: 추가 기능 구현
    public Rank findRank(WinNumber winNumber) {
        int countOfWin = winNumber.countMatchingNumbers(numbers);
        boolean matchBonus = winNumber.isMatchBonus(numbers);
        return matchRank(countOfWin, matchBonus);
    }

    private static Rank matchRank(int countOfWin, boolean matchBonus) {
        if (isRank3(countOfWin)) {
            return FIFTH;
        }
        if (isRank4(countOfWin)) {
            return FOURTH;
        }
        if (isRank3(countOfWin, matchBonus)) {
            return THIRD;
        }
        if (isRank2(countOfWin)) {
            return SECOND;
        }
        if (isRank1(countOfWin)) {
            return FIRST;
        }
        return NONE;
    }

    private static boolean isRank1(int countOfWin) {
        return countOfWin == 6;
    }

    private static boolean isRank2(int countOfWin) {
        return countOfWin == 5;
    }

    private static boolean isRank3(int countOfWin, boolean matchBonus) {
        return countOfWin == 5 && !matchBonus;
    }

    private static boolean isRank4(int countOfWin) {
        return countOfWin == 4;
    }

    private static boolean isRank3(int countOfWin) {
        return countOfWin == 3;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}