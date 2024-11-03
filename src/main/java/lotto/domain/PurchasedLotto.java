package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchasedLotto {
    private List<Lotto> lottos;
    private Map<Prize, Integer> prizes;
    private int usedMoney;
    private long earnedMoney;

    public PurchasedLotto() {
        this.lottos = new ArrayList<>();
        this.prizes = new HashMap<>();
        this.usedMoney = 0;
        this.earnedMoney = 0;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Prize, Integer> getPrizes() {
        return prizes;
    }

    public double getRateOfReturn(){
        return ((double)earnedMoney / usedMoney) * 100;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
        usedMoney += Constant.LOTTO_PRICE;
    }

    public void matchLotto(WinningNumber winningNumber) {
        for (Lotto lotto : lottos) {
            Prize prize = winningNumber.matchCount(lotto);
            earnedMoney += prize.getRewards();

            prizes.put(prize, prizes.getOrDefault(prize, 0) + 1);

        }
    }

}
