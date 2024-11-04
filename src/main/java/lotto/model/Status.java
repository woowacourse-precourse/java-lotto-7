package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Status {
    private final List<Integer> numbersHit;
    private final List<Boolean> bonusHit;

    public Status() {
        numbersHit = new ArrayList<>();
        bonusHit = new ArrayList<>();
    }

    public void checkNumbersHit(Tickets tickets, Jackpot jackpot) {
        List<Lotto> lottoTickets = tickets.getTickets();

        for (Lotto ticket : lottoTickets) {
            List<Integer> ticketNumbers = ticket.getNumbers();

            Lotto lottoNumbers = jackpot.getLottoNumbers();
            List<Integer> jackpotNumbers = lottoNumbers.getNumbers();

            ticketNumbers.retainAll(jackpotNumbers);
            int numbersHitCount = ticketNumbers.size();

            numbersHit.add(numbersHitCount);
        }
    }

    public void checkBonusHit(Tickets tickets, Jackpot jackpot) {
        List<Lotto> lottoTickets = tickets.getTickets();

        for (Lotto ticket : lottoTickets) {
            List<Integer> ticketNumbers = ticket.getNumbers();

            int jackpotBonus = jackpot.getBonusNumber();
            boolean isBonusHit = ticketNumbers.contains(jackpotBonus);

            bonusHit.add(isBonusHit);
        }
    }

    public List<Integer> getNumbersHit() {
        return numbersHit;
    }

    public List<Boolean> getBonusHit() {
        return bonusHit;
    }
}