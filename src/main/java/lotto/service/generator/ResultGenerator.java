package lotto.service.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;

public class ResultGenerator {

    private static final Integer TRUE = 1;
    private static final Integer FALSE = 0;

    private final List<Integer> winningResult = new ArrayList<>();
    private final List<Integer> bonusResult = new ArrayList<>();

    private ResultGenerator(List<Lotto> lottoTicket, Lotto winning, Bonus bonus) {
        compareTicketToWinning(lottoTicket, winning);
        compareTicketToBonus(lottoTicket, bonus);
    }

    public static ResultGenerator create(List<Lotto> lottoTicket, Lotto winning, Bonus bonus) {
        return new ResultGenerator(lottoTicket, winning, bonus);
    }

    private void compareTicketToWinning(List<Lotto> lottoTicket, Lotto winning) {
        lottoTicket.forEach(lotto -> countWinning(lotto, winning));
    }

    private void countWinning(Lotto lotto, Lotto winning) {
        winningResult.add((int) lotto.getNumbers().stream()
                .filter(number -> winning.getNumbers().contains(number))
                .count());
    }

    private void compareTicketToBonus(List<Lotto> lottoTicket, Bonus bonus) {
        lottoTicket.forEach(lotto -> countBonus(lotto, bonus));
    }

    private void countBonus(Lotto lotto, Bonus bonus) {
        if (IsContainBonus(lotto.getNumbers(), bonus.getNumber())) {
            bonusResult.add(TRUE);
            return;
        }
        bonusResult.add(FALSE);
    }

    private boolean IsContainBonus(List<Integer> lotto, Integer bonus) {
        return lotto.contains(bonus);
    }

    public List<Integer> getWinningResult() {
        return winningResult;
    }

    public List<Integer> getBonusResult() {
        return bonusResult;
    }
}