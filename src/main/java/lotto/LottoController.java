package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private List<Lotto> purchasedTickets = new ArrayList<>();
    private Lotto winningNumbers;
    private int bonusNumber;


    public void run() {
        int purchaseAmount = LottoView.inputPurchaseAmount();
        purchaseTickets(purchaseAmount);
        LottoView.printPurchasedTickets(purchasedTickets);

        winningNumbers = LottoView.inputWinningNumbers();
        bonusNumber = LottoView.inputBonusNumber();

        Result result = calculateResults();
        double profitRate = result.calculateProfitRate(purchaseAmount);
        LottoView.printResults(result.getResultCounts(), profitRate);
    }

    private void purchaseTickets(int price) {
        int ticketCount = price / 1000;
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> ticketNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()
                    .toList();
            purchasedTickets.add(new Lotto(ticketNumbers));
        }
    }

    private Result calculateResults() {
        Result result = new Result();
        for (Lotto ticket : purchasedTickets) {
            int matchCount = ticket.countMatchingNumbers(winningNumbers);
            boolean hasBonus = ticket.containsBonusNumber(bonusNumber);
            result.addResult(matchCount, hasBonus);
        }
        return result;
    }
}
