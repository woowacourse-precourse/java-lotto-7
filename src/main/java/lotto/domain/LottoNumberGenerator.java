package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {
    private final int minNumber;
    private final int maxNumber;
    private final int count;

    public LottoNumberGenerator(int minNumber, int maxNumber, int count) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.count = count;
    }

    public List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, count);
    }
}
