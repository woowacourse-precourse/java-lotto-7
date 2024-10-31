package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int GENERATED_NUMBERS = 6;

    public List<Integer> getLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(MIN, MAX, GENERATED_NUMBERS);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }
}
