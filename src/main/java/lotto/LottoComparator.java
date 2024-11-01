package lotto;

import java.util.List;

public class LottoComparator {

    private final List<Lotto> customerTickets;
    private final Lotto winningTicket;
    private final int bonusNumber;

    public LottoComparator(List<Lotto> customerTickets, Lotto winningTicket, int bonusNumber) {
        this.customerTickets = customerTickets;
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public void calculateResult(){
        for (Lotto customerTicket : customerTickets) {
            int matchCount = getMatchCount(customerTicket.getNumbers(), winningTicket.getNumbers());
            boolean bonusMatch = customerTicket.getNumbers().contains(bonusNumber);
            LottoRank rank = LottoRank.getLottoRank(matchCount, bonusMatch);
        }
    }

    public int getMatchCount(List<Integer> customerNumbers, List<Integer> winningNumbers){
        int count = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            if(customerNumbers.contains(winningNumbers.get(i)));
                count++;
        }
        return count;
    }
}
