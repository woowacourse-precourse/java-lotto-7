package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumbers {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    public List<Integer> generateRandomLottoNumbers(){
        List<Integer> lottoNumbers =  new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
