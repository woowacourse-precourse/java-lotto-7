package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoVendingMachine {


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
