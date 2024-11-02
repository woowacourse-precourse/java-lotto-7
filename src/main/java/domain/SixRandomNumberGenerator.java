package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class SixRandomNumberGenerator {

    public static List<Integer> generateSixRandomNumber() {
        List<Integer> numbers = new ArrayList<>();

        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
