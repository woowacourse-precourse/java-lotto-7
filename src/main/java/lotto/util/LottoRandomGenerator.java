package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoRandomGenerator {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 45;
    private static final int RANDOM_COUNT = 6;

    private LottoRandomGenerator() {
        // 인스턴스화 방지
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER, RANDOM_COUNT);
        Collections.sort(randomNumbers);  // 오름차순 정렬
        return randomNumbers;
    }

}
