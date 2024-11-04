package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final LottoView view;
    private List<Lotto> purchasedTickets;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoController(LottoView view) {
        this.view = view;
        this.purchasedTickets = new ArrayList<>();
    }

    public void run() {
        int price = view.inputPurchaseAmount();
        purchaseTickets(price);
        view.printPurchasedTickets(purchasedTickets);

        winningNumbers = view.inputWinningNumbers();
        bonusNumber = view.inputBonusNumber();

        Result result = calculateResults();
        double profitRate = result.calculateProfitRate(price);
        view.printResults(result.getResultCounts(), profitRate);
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
