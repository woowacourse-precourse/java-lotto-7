package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static final int COUNT_NUM = 6;
    private static final int BONUS_NUM = 1;

    public List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, COUNT_NUM);
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
