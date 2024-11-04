package lotto.util.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.LottoOption;

public class RandomNumbersGenerator {
    public static List<Integer> generateNumbers(){
        return Randoms.pickUniqueNumbersInRange(LottoOption.MIN_LOTTO_NUMBER, LottoOption.MAX_LOTTO_NUMBER, LottoOption.LOTTO_NUMBER_COUNT);
    }
}
