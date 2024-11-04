package lotto;

import lotto.input.BonusNumber;
import lotto.input.WinningNumber;

import java.util.*;

public class WinningStatus {

    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;
    private List<Lotto> lottoList;
    private Set<Integer> winningSet;
    private Map<Integer, Match> map;


    public WinningStatus(WinningNumber winningNumber, BonusNumber bonusNumber, List<Lotto> lottoList) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.lottoList = lottoList;
        this.winningSet = new HashSet<>();
        this.map = new HashMap<>();

        winningSet.addAll(winningNumber.getLotto().getNumbers());
        map.put(3, Match.MATCH_3);
        map.put(4, Match.MATCH_4);
        map.put(5, Match.MATCH_5);
        map.put(6, Match.MATCH_6);
        map.put(7, Match.MATCH_5_BONUS);
    }

    public void matchLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            matching(lotto);
        }
    }

    private void matching(Lotto lotto) {
        int count = 0;

        for (int num : lotto.getNumbers()) {
            if (winningSet.contains(num)) count++;
        }

        if (count == 5) {
            if (isBonusNumberMatch(lotto)) {
                map.get(7).numberMatch();
                return;
            }
        }

        if (count >= 3) map.get(count).numberMatch();
    }

    private boolean isBonusNumberMatch(Lotto lotto) {
        for (int num : lotto.getNumbers()) {
            if (num == bonusNumber.getBonusNumber()) return true;
        }

        return false;
    }
}
