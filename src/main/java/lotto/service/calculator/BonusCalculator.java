package lotto.service.calculator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;

public class BonusCalculator {

    private static final Integer TRUE = 1;
    private static final Integer FALSE = 0;

    private final List<Integer> bonusResult = new ArrayList<>();

    private BonusCalculator(List<Lotto> lottoTicket, Bonus bonus) {
        compareTicketToBonus(lottoTicket, bonus);
    }

    public static BonusCalculator create(List<Lotto> lottoTicket, Bonus bonus) {
        return new BonusCalculator(lottoTicket, bonus);
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

    public List<Integer> getBonusResult() {
        return bonusResult;
    }
}
