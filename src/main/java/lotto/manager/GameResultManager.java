package lotto.manager;

import lotto.domain.*;
import java.util.List;


public class GameResultManager {
    private WinningLotto winningLotto;

    public void changeWinningLotto(List<Integer> winningNumbers, int bonusNumber) {

        this.winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    private Map<Prize, Integer> getPrizeCountFrom(Player player) {

        return player.getLottos().stream()
                .map(this::getPrizeOf)
                .collect(Collectors.groupingBy(
                        prize -> prize,
                        Collectors.summingInt(prize -> 1)
                ));
    }

    private Prize getPrizeOf(Lotto lotto) {

        int matchCount = countMatchNumberWith(lotto);
        boolean bonusFlag = matchBonusNumberWith(lotto);

        return Prize.getMatchPrize(matchCount, bonusFlag);
    }

    private int countMatchNumberWith(Lotto lotto) {
        int count = 0;

        for (Integer number : lotto.getImmutableNumbers()) {
            if (winningLotto.getImmutableWinningNumbers().contains(number)) {
                count++;
            }
        }

        return count;
    }

    private boolean matchBonusNumberWith(Lotto lotto) {

        return lotto.getImmutableNumbers().contains(winningLotto.getImmutableBonusNumber().getNumber());
    }
}
