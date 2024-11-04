package lotto.application.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.application.model.Lotto;
import lotto.application.model.WinningRanking;

public class LottoAnchor {

    private List<Integer> winningNumbers;
    private int bonusNumber;
    private EnumMap<WinningRanking, Integer> winningRankings;

    public LottoAnchor() {
        initiateEnumMap();
    }

    private void initiateEnumMap() {
        winningRankings = new EnumMap<>(WinningRanking.class);

        Arrays.stream(WinningRanking.values()).forEach(winningRanking -> {
            winningRankings.put(winningRanking, 0);
        });
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = new ArrayList<>(winningNumbers);
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public EnumMap<WinningRanking, Integer> announce(Collection<Lotto> lottos) {
        lottos.forEach(lotto -> {
            WinningRanking key = lotto.match(winningNumbers, bonusNumber);

            winningRankings.compute(key, (k, count) -> count + 1);
        });

        return winningRankings;
    }

}
