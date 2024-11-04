package lotto.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.Rank;

public class LottoResultChecker {

    private final List<Integer> winningNumber;
    private final Integer bonusNumber;
    private final Map<Rank, Integer> lottoResult = new EnumMap<>(Rank.class);

    public LottoResultChecker(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        initializeLottoResult();
    }

    public Map<Rank, Integer> getLottoResult() {
        return lottoResult;
    }

    public void checkLottoResult(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchNumber = getMatchNumber(lotto);
            boolean matchBonus = getMatchBonus(lotto);

            Rank rank = Rank.getRank(matchNumber, matchBonus);
            putResult(rank);
        }
    }

    private void putResult(Rank rank) {
        if (rank != null) {
            lottoResult.put(rank, lottoResult.get(rank) + 1);
        }
    }

    private int getMatchNumber(Lotto lotto) {
        List<Integer> intersection = new ArrayList<>(winningNumber);
        intersection.retainAll(lotto.getNumbers());
        return intersection.size();
    }

    private boolean getMatchBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void initializeLottoResult() {
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }
    }
}
