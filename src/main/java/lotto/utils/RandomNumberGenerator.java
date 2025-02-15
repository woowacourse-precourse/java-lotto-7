package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
    private final static Integer START=1;
    private final static Integer END=45;
    private final static Integer COUNT=6;
    public static List<Integer> genreateNumbers(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(START, END, COUNT));
        Collections.sort(numbers);
        return numbers;
    }
}
