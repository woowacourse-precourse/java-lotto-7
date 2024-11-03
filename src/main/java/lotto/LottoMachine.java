package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.Lotto;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> purchasedLottos = new ArrayList<>();

    public void purchaseLottos(int amount) {
        int count = amount / LOTTO_PRICE;
        System.out.printf("%d개를 구매했습니다.%n", count);
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            purchasedLottos.add(lotto);
            System.out.println(numbers);
        }
    }
}
