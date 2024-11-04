package lotto;

import java.util.List;

public class LottoGame {
    private final LottoMachine lottoMachine = new LottoMachine();

    public void start() {
        try {
            int purchaseAmount = InputParser.parsePurchaseAmount();
            List<Lotto> tickets = lottoMachine.generateTickets(purchaseAmount);
            System.out.println(tickets.size() + "개를 구매했습니다.");
            tickets.forEach(System.out::println);

            List<Integer> winningNumbers = InputParser.parseWinningNumbers();
            int bonusNumber = InputParser.parseBonusNumber();
            LottoResult result = lottoMachine.calculateResults(tickets, winningNumbers, bonusNumber);

            result.printStatistics(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
