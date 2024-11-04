package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    public Lotto generateLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBERS_COUNT);
        lottoNumbers.sort(Integer::compareTo);
        return new Lotto(lottoNumbers);
    }
}
