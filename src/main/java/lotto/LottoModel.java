package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoModel {
    public List<Integer> getLottoNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
