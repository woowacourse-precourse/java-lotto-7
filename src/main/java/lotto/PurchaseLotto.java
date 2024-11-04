package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLotto {
    private final List<Lotto> lottos = new ArrayList<>();

    public void salesLotto(int lottoMoney) {
        int lottoCount = lottoMoney / 1000;
        System.out.println(lottoCount + "개를 구매했습니다. ");

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
            System.out.println(numbers);
        }
    }
}
