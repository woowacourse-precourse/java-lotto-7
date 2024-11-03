package lotto.domain.lottoNumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {

    private final int startInclusive = LottoRange.LOTTO.getStart();
    private final int endInclusive = LottoRange.LOTTO.getEnd();
    private final int count = LottoRange.LOTTO.getCount();

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }

    public String getPurchasedLotto(int lottoCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = generateRandomNumbers();
            Collections.sort(randomNumbers);
            sb.append(randomNumbers.toString()).append("\n");
        }
        return sb.toString();
    }

}