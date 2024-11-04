package lotto.domain;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class CustomLottoGenerator implements LottoGenerator {
    public List<Integer> generate() {
        List<Integer> lotto = generateRandomUniqueNumberInRange(1, 45, 6);
        // 오름차순으로 정렬
        Collections.sort(lotto);
        return lotto;
    }

    public List<Integer> generateRandomUniqueNumberInRange(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
