package lotto.domain;

import java.util.List;

public class Player {

    private final int money;
    private final List<Lotto> lottos;

    public static Player create(List<Lotto> lottos, int money) {
        return new Player(lottos, money);
    }

    private Player(List<Lotto> lottos, int money) {
        this.lottos = lottos;
        this.money = money;
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

    public double calculateReturnRate(Long totalPrizeMoney) {
        return (double)totalPrizeMoney / money * 100;
    }
}
