package lotto.domain;

import java.util.List;
import lotto.utils.Prize;

public class LottoResult {
    private final int match3Count;
    private final int match4Count;
    private final int match5Count;
    private final int match5WithBonusCount;
    private final int match6Count;
    private final int totalPrize;

    public LottoResult(List<Lotto> lottos, WinningNumbers winningNumbers) {
        LottoEvaluator evaluator = new LottoEvaluator(winningNumbers);

        this.match3Count = (int) lottos.stream().filter(lotto -> evaluator.getMatchingCount(lotto) == Prize.MATCH3.getMatchCount()).count();
        this.match4Count = (int) lottos.stream().filter(lotto -> evaluator.getMatchingCount(lotto) == Prize.MATCH4.getMatchCount()).count();
        this.match5Count = (int) lottos.stream().filter(lotto -> evaluator.getMatchingCount(lotto) == Prize.MATCH5.getMatchCount() && !evaluator.containsBonus(lotto)).count();
        this.match5WithBonusCount = (int) lottos.stream().filter(lotto -> evaluator.getMatchingCount(lotto) == Prize.MATCH5_WITH_BONUS.getMatchCount() && evaluator.containsBonus(lotto)).count();
        this.match6Count = (int) lottos.stream().filter(lotto -> evaluator.getMatchingCount(lotto) == Prize.MATCH6.getMatchCount()).count();

        this.totalPrize = match3Count * Prize.MATCH3.getPrizeMoney() + match4Count * Prize.MATCH4.getPrizeMoney() + match5Count * Prize.MATCH5.getPrizeMoney()
            + match5WithBonusCount * Prize.MATCH5_WITH_BONUS.getPrizeMoney() + match6Count * Prize.MATCH6.getPrizeMoney();
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
