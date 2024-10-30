package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator implements CreateRandomNumbers {

    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int LOTTO_SIZE = 6;

    @Override
    public List<Integer> getRandomNumbers() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
        Collections.sort(lottoNumber);

        return lottoNumber;
    }
}
