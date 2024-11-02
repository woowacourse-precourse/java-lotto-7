package lotto.domain;

import static lotto.contant.Constants.MATCH3_PRIZE;
import static lotto.contant.Constants.MATCH4_PRIZE;
import static lotto.contant.Constants.MATCH5_PRIZE;
import static lotto.contant.Constants.MATCH5_WITH_BONUS_PRIZE;
import static lotto.contant.Constants.MATCH6_PRIZE;

import java.util.List;

public class LottoResult {
    private final int match3Count;
    private final int match4Count;
    private final int match5Count;
    private final int match5WithBonusCount;
    private final int match6Count;
    private final int totalPrize;

    public LottoResult(List<Lotto> lottos, WinningNumbers winningNumbers) {
        LottoEvaluator evaluator = new LottoEvaluator(winningNumbers);

        this.match3Count = (int) lottos.stream().filter(lotto -> evaluator.getMatchingCount(lotto) == 3).count();
        this.match4Count = (int) lottos.stream().filter(lotto -> evaluator.getMatchingCount(lotto) == 4).count();
        this.match5Count = (int) lottos.stream().filter(lotto -> evaluator.getMatchingCount(lotto) == 5 && !evaluator.containsBonus(lotto)).count();
        this.match5WithBonusCount = (int) lottos.stream().filter(lotto -> evaluator.getMatchingCount(lotto) == 5 && evaluator.containsBonus(lotto)).count();
        this.match6Count = (int) lottos.stream().filter(lotto -> evaluator.getMatchingCount(lotto) == 6).count();

        this.totalPrize = match3Count * MATCH3_PRIZE + match4Count * MATCH4_PRIZE + match5Count * MATCH5_PRIZE
            + match5WithBonusCount * MATCH5_WITH_BONUS_PRIZE + match6Count * MATCH6_PRIZE;
    }

    public int getMatch3Count() {
        return match3Count;
    }

    public int getMatch4Count() {
        return match4Count;
    }

    public int getMatch5Count() {
        return match5Count;
    }

    public int getMatch5WithBonusCount() {
        return match5WithBonusCount;
    }

    public int getMatch6Count() {
        return match6Count;
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
