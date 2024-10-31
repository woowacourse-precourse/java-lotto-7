package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNum {
    private List<Lotto> lottos = new ArrayList<>();

    public LottoNum(int money) {
        checkMoney(money);
        lottoNumbers(money);
        printNumber();
    }

    private void checkMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000원으로 나누어 떨어지지 않습니다.");
        }
    }

    private void lottoNumbers(int money) {
        for (int i = 0; i < money / 1000; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public void printNumber() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
