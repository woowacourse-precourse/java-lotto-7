package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class SixRandomNumberGenerator {

    public static List<Integer> generateSixRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
