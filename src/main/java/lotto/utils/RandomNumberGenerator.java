package lotto.utils;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;


public class RandomNumberGenerator {
    public static List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
