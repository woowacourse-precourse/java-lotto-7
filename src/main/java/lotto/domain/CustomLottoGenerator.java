package lotto.domain;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CustomLottoGenerator implements LottoGenerator {
    public List<Integer> generate() {
        return generateRandomUniqueNumberInRange(1, 45, 6);
    }

    public List<Integer> generateRandomUniqueNumberInRange(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
