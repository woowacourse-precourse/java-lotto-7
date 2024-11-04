package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGenerator {
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static final int COUNT_NUM = 6;
    private static final int BONUS_NUM = 1;

    public Set<Integer> getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, COUNT_NUM);
        return new HashSet<>(numbers);
    }

    public int getBonusNumber() {
        return Randoms.pickNumberInRange(START_NUM, END_NUM);
    }

    private LottoGenerator() {

    }

    public static LottoGenerator createLottoGenerator() {
        return new LottoGenerator();
    }
}
