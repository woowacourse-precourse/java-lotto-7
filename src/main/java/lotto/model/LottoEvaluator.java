package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoEvaluator {
    private final Money money;
    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;

    public LottoEvaluator(Money money, List<Lotto> lottos, WinningLotto winningLotto) {
        this.money = money;
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public List<LottoRank> evaluateTicketsRank() {
        return lottos.stream()
                .map(this::evaluateTicketRank)
                .collect(Collectors.toList());
    }

    private LottoRank evaluateTicketRank(Lotto lotto) {
        long lottoMatchingNumber = lotto.getNumbers().stream()
                .filter(winningLotto.getWinningLotto()::contains)
                .count();

        boolean isBonusNumberMatching = lotto.getNumbers().contains(winningLotto.getBonusNumber());

        return LottoRank.valueOf((int) lottoMatchingNumber, isBonusNumberMatching);
    }

    public Double calculateRateOfReturn(Integer totalIncome) {
        return ((double) totalIncome / (money.getMoney())) * 100;
    }
}
