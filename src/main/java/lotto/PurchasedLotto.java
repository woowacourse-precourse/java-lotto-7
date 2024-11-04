package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class PurchasedLotto {
    private final List<Lotto> lottos;
    private final int size;

    private PurchasedLotto(List<Lotto> lottos) {
        this.lottos = lottos;
        size = lottos.size();
    }

    public int getSize() {
        return size;
    }

    public static PurchasedLotto generateLottos(int generateCount, Supplier<List<Integer>> supplier) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < generateCount; i++) {
            lottos.add(Lotto.generateLotto(supplier.get()));
        }
        return new PurchasedLotto(lottos);
    }

    public Map<Prize, Integer> checkWin(List<Integer> winNumber, int bonusNumber) {
        Map<Prize, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            result.merge(lotto.checkWin(winNumber, bonusNumber), 1, Integer::sum);
        }
        return result;
    }

    public void printPurchasedLotto() {
        for (Lotto lotto : lottos) {
            lotto.printNumber();
        }
    }
}
