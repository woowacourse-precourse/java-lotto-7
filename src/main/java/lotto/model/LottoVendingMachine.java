package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoVendingMachine {

    public List<Lotto> issueNewLottos(int money) {
        checkMoney(money);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < money / 1000; i++) {
            Lotto lotto = issueNewLotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    private Lotto issueNewLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }

    private void checkMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
