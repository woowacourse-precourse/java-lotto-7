package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.Rank;

public class LottoChecker {

    private final Lottos lottos;
    private final WinningNumber winningNumber;
    private List<Rank> result = new ArrayList<>();

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
        int match = 0;
        boolean isBonus = false;

        for (int number : lotto.getNumbers()) {

            if (winningNumber.getWinningNumbers().contains(number)) {
                match += 1;
            }

            if (match == 5 && lotto.getNumbers().contains(winningNumber.getBonusNumber())) {
                isBonus = true;
            }
        }

        return Rank.of(match, isBonus);
    }

    public Map<Integer, Integer> getResultMap() {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (Rank rank : result) {
            resultMap.put(rank.getPlace(), resultMap.getOrDefault(rank.getPlace(), 0) + 1);
        }

        return resultMap;
    }
}
