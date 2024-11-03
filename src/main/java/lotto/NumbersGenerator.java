package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumbersGenerator {

    public static final int MIN = 1;
    public static final int MAX = 45;

    public List<Integer> generateNumbers(int number) {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, number);
    }
}
