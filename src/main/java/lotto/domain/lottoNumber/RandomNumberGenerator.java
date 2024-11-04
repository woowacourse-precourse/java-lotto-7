package lotto.domain.lottoNumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {

    private static final int startInclusive = LottoRange.LOTTO.getStart();
    private static final int endInclusive = LottoRange.LOTTO.getEnd();
    private static final int count = LottoRange.LOTTO.getCount();

    public static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
        Collections.sort(randomNumbers);
        return randomNumbers;
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