package lotto.domain;

import java.util.List;

public class Player {

    private final List<Lotto> lottos;

    public static Player create(List<Lotto> lottos) {
        return new Player(lottos);
    }

    private Player(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public History compareToWinning(Winning winning, Bonus bonus) {
        History history = new History();
        for (Lotto lotto : lottos) {
            long hitCount = lotto.getHitCount(winning);
            long bonusCount = lotto.getBonusHitCount(bonus);
            history.addHistory(hitCount, bonusCount);
        }

        return history;
    }
}
