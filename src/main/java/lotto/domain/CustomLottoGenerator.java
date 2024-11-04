package lotto.domain;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CustomLottoGenerator implements LottoGenerator {
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_SIZE = 6;

    public List<Integer> generate() {
        return generateRandomUniqueNumberInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_SIZE);
    }

    public List<Integer> generateRandomUniqueNumberInRange(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
