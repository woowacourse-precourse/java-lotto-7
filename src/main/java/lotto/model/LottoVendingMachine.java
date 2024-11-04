package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Validation;

import java.util.ArrayList;
import java.util.List;

public class LottoVendingMachine {

    public static List<Lotto> issueNewLottos(int money) {
        Validation.validateMoneyUnit(money);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < money / 1000; i++) {
            Lotto lotto = issueNewLotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    private static Lotto issueNewLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }


}
