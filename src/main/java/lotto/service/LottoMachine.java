package lotto.service;

import lotto.data.Lotto;
import lotto.constants.Value;
import lotto.data.Database;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class LottoMachine {

    public void buyLotto(Long money) {
        Long lottoCount = money / Value.lottoPrice;
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumber = pickUniqueNumbersInRange(Value.lottoStartNumber, Value.lottoEndNumber, Value.lottoNumberCount);
            Database.purchaseLottoList.add(new Lotto(lottoNumber));
            System.out.println(lottoNumber);
        }
    }

    public List<Lotto> getPurchasedLotto() {
        return Database.purchaseLottoList;
    }
}
