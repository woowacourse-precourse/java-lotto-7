package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> createLottoNumbers(int start, int end, int count) {
        //Randoms.pickUniqueNumbersInRange()가 불변 리스트를 반환할 수 있다는 가정(테스트 코드)
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(start, end, count));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
