package lotto.model;

import java.util.*;

public class LottoEvaluator {
    private int purchaseAmount;
    private List<Lotto> lottos;
    private Lotto winningLotto;
    private int bonusNum;
    private Map<Rank, Integer> lottoStats;
    private double profit;

    public LottoEvaluator(int purchaseAmount, List<Lotto> lottos, Lotto winningLotto, int bonusNum) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
        this.lottoStats = new HashMap<>();
        this.profit = 0;
    }

}
