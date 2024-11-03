package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LIMIT_LOTTO_NUMBER_SIZE = 6;

    public static List<Integer> lottoNumbers(){
        List<Integer> tempNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LIMIT_LOTTO_NUMBER_SIZE);
        Collections.sort(tempNumbers);
        return tempNumbers;
    }
}
