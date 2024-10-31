package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResults {
    private final List<Lotto> userLottos;
    private final Lotto winningLotto;
    private final int bonusNumber;
    private final Map<Rank, Integer> resultMap = new HashMap<>();

    public LottoResults(List<Lotto> userLottos, Lotto winningLotto, int bonusNumber) {
        this.userLottos = userLottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        initializeResultMap();
    }

    private void initializeResultMap() {
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
    }

    public void calculateResult() {
        for (Lotto lotto : userLottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningLotto.getNumbers()::contains)
                    .count();
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.getRank(matchCount, bonusMatch);
            resultMap.put(rank, resultMap.get(rank) + 1);
        }
    }

    public Map<Rank, Integer> getResultMap() {
        return resultMap;
    }
}
