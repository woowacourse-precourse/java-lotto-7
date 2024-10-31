package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final List<Lotto> lottos = new ArrayList<>();

    public void purchaseLottos(int purchaseAmount) {
        int count = purchaseAmount / 1000;
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public void printLottos() {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
