package lotto.domain.winning;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatics {

    EnumMap<WinningRank, Integer> winningStatics = new EnumMap<>(WinningRank.class);

    public WinningStatics() {
        for (WinningRank winningRank : WinningRank.values()) {
            winningStatics.put(winningRank, 0);
        }
    }

    public Map<WinningRank, Integer> getWinningStatics() {
        return winningStatics;
    }

    public int getWinningCount(WinningRank winningRank) {
        return winningStatics.get(winningRank);
    }

    public void numOfWinnings(List<List<Integer>> lottos, WinningNumber winningNumber) {
        for (List<Integer> lotto : lottos) {
            boolean containBonusNumber = false;
            List<Integer> matchedNumbers = new ArrayList<>(lotto);

            if (matchedNumbers.contains(winningNumber.getBonusNumber())) {
                containBonusNumber = true;
            }

            matchedNumbers.retainAll(winningNumber.getWinningNumbers());
            increase(WinningRank.getWinningRank(matchedNumbers.size(), containBonusNumber));
        }
    }

    private void increase(WinningRank winningRank) {
        winningStatics.put(winningRank, winningStatics.get(winningRank) + 1);
    }
}
