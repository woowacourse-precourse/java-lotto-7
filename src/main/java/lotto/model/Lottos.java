package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    List<Lotto> lottos;

    public Lottos(PurchaseAmount purchaseAmount) {
        lottos = new ArrayList<>();

        int buyCount = purchaseAmount.getBuyCount();
        for (int i = 0; i < buyCount; i++) {
            lottos.add(Lotto.generateLotto());
        }
    }

    public int getCount() {
        return lottos.size();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
