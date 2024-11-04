package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos = new ArrayList<>();
    private final Map<Rank, Integer> result = new HashMap<>();

    public void purchaseLottos(int purchaseAmount) {
        int count = purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.generateRandomLotto());
        }
    }

    public void calculateResults(WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            if (rank != null) {
                result.put(rank, result.getOrDefault(rank, 0) + 1);
            }
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }
}
