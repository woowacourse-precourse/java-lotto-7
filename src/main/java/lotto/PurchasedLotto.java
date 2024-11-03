package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLotto {
    private final List<Lotto> lottos;
    private final int size;

    private PurchasedLotto(List<Lotto> lottos) {
        this.lottos = lottos;
        size = lottos.size();
    }

    public static PurchasedLotto generateLottos(int generateCount){
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < generateCount; i++) {
            lottos.add(Lotto.generateLotto(Randoms.pickUniqueNumbersInRange(1,45,6)));
        }
        return new PurchasedLotto(lottos);
    }
    public int getSize() {
        return size;
    }
}
