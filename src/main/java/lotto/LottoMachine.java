package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

import static lotto.LottoData.*;

public class LottoMachine {

    public void action(int count, MyLotto myLotto) {
        int index = 0;
        while (index++ < count) {
            myLotto.add(randomLottoNumbers());
        }
    }

    private Lotto randomLottoNumbers() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(START_NUM.getNum(), END_NUM.getNum(), BALLS.getNum()));
    }
}
