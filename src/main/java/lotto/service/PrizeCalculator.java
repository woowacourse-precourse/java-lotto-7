package lotto.service;

import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinningLotto;

import java.util.EnumMap;
import java.util.List;

public class PrizeCalculator {

    private EnumMap<Prize, Integer> prizeCount;

    public PrizeCalculator() {
        this.prizeCount = initPrizes();
    }

    private EnumMap<Prize, Integer> initPrizes() {
        EnumMap<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }
        return prizeCount;
    }

    public void calculatePrizes(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.compareTo(winningLotto.getNumber());


            for(Prize prize : Prize.values()){
                updatePrizeCount(lotto, winningLotto, prize, matchCount);
            }

        }
    }
    public EnumMap<Prize, Integer> getPrizeCount(){
        return this.prizeCount;
    }

    private void updatePrizeCount(Lotto lotto, WinningLotto winningLotto, Prize prize, int matchCount) {

        if (matchCount == prize.getRanking()) {
            if (lotto.hasBonusNumber(winningLotto.getBonusNumber()) && prize.equals(Prize.THIRD)) { // 추후에 이 조건이 바뀔수도 있다면 이걸 따로 조건검색하는 메소드를 만드는것도 괜찮을거 같다
                return;
            }

            prizeCount.put(prize, prizeCount.get(prize) + 1);
        }
    }

    public double calculateWinningRate(int amountInput) {
        int winningRate = 0;
        for (Prize prize : prizeCount.keySet()) {
            winningRate += (int) (prize.getPrizeMoney() * prizeCount.get(prize));
        }
        return (double) winningRate / amountInput * 100;
    }

}
