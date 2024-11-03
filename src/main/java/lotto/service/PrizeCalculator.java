package lotto.service;

import lotto.constant.Constants;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinningLotto;

import java.util.EnumMap;
import java.util.List;

public class PrizeCalculator {

    private final EnumMap<Prize, Integer> prizeCount;

    public PrizeCalculator() {
        this.prizeCount = initPrizes();
    }

    private EnumMap<Prize, Integer> initPrizes() {
        EnumMap<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);

        for (Prize prize : Prize.values()) {
            prizeCount.put(prize, Constants.ZERO);
        }
        return prizeCount;
    }

    public void calculatePrizes(List<Lotto> lottos, WinningLotto winningLotto) {

        for (Lotto lotto : lottos) {

            int matchCount = lotto.compareTo(winningLotto.getWinningLotto());

            for (Prize prize : Prize.values()) {
                updatePrizeCount(lotto, winningLotto, prize, matchCount);
            }
        }
    }

    public EnumMap<Prize, Integer> getPrizeCount() {
        return this.prizeCount;
    }

    private void updatePrizeCount(Lotto lotto, WinningLotto winningLotto, Prize prize, int matchCount) {

        if (matchCount == prize.getRanking()) {

            if (isNotThirdPrize(lotto, winningLotto, prize)) { // 번호는 5개가 맞았고 보너스 번호도 있다면 2등이지만 prize를 앞에서부터 도는 순서상 3등일때도 인식될수 있기 때문에 3등인지 여부를 검사한다
                return;
            }
            prizeCount.put(prize, prizeCount.get(prize) + Constants.INCREASE_VALUE_ONE);
        }
    }

    private boolean isNotThirdPrize(Lotto lotto, WinningLotto winningLotto, Prize prize) {
        return lotto.hasBonusNumber(winningLotto.getBonusNumber()) && prize.equals(Prize.THIRD);
    }

    public double calculateWinningRate(int amountInput) {
        int winningRate = 0;

        for (Prize prize : prizeCount.keySet()) {
            winningRate += (int) (prize.getPrizeMoney() * prizeCount.get(prize));
        }
        return (double) winningRate / amountInput * Constants.GET_PERCENTAGE_BY_HUNDRED;
    }

}
