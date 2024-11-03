package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoVendingMachine {

    public static List<Lotto> issueNewLottos(int money) {
        checkMoney(money);
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

    private static void checkMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액은 1000원 단위어야 합니다.");
        }
    }
}
