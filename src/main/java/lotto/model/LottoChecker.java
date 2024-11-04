package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.util.Rank;

public class LottoChecker {

    private final Lottos lottos;
    private final WinningNumber winningNumber;
    private final List<Rank> result = new ArrayList<>();

    public LottoChecker(Lottos lottos, WinningNumber winningNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
    }

    public List<Rank> checkLottos() {
        for (Lotto lotto : lottos.getLottos()) {
            result.add(checkLotto(lotto));
        }

        return result;
    }

    private Rank checkLotto(Lotto lotto) {
        int matchCount = (int)lotto.getNumbers().stream()
            .filter(winningNumber.getWinningNumbers()::contains)
            .count();

        boolean isBonusMatched = matchCount == 5 &&
            lotto.getNumbers().contains(winningNumber.getBonusNumber());

        return Rank.of(matchCount, isBonusMatched);
    }

    public Map<Integer, Integer> getResultMap() {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (Rank rank : result) {
            resultMap.put(rank.getPlace(), resultMap.getOrDefault(rank.getPlace(), 0) + 1);
        }

        return resultMap;
    }
}
