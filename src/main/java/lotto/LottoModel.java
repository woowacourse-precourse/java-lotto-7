package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoModel {
    public Lotto getLottoNumber(){
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        lotto.sortNumbers();

        return lotto;
    }
}
