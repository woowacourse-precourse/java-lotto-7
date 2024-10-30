package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> generateLottoNumbers(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return lottoNumbers;
    }
}
