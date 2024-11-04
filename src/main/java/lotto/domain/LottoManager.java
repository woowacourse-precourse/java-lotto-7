package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum LottoManager {
    INSTANCE;

    private static final int LOTTO_PRICE = 1000;

    public Integer getPurchasableLottos(Long purchaseAmount) {
        return (int) (purchaseAmount / LOTTO_PRICE);
    }

    public List<Lotto> purchaseLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Lotto.createNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    public Map<LottoRank, Integer> drawResult(List<Lotto> lottos, WinLotto winLotto) {
        Map<LottoRank, Integer> result = new HashMap<>();
        lottos.forEach(lotto ->
                result.merge(
                        LottoRank.matchNumbers(lotto, winLotto), 1, Integer::sum
                )
        );

        return result;
    }

    public Long calculatePrize(Map<LottoRank, Integer> result) {
        return result.entrySet().stream()
                .mapToLong(entry -> (long) entry.getValue() * entry.getKey().getPrize())
                .sum();
    }
}
