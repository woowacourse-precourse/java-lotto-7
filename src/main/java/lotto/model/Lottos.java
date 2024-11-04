package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

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

    public List<LottoRank> matchLottos(Lotto winNumbers, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.getRank(winNumbers, bonusNumber))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
