package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private final LottoMachine lottoMachine;

    public LottoGame() {
        this.lottoMachine = new LottoMachine();
    }

    public void start(int purchaseAmount, List<Integer> winningNumbers, int bonusNumber) {
        List<Lotto> tickets = lottoMachine.createTickets(purchaseAmount);
        lottoMachine.printTickets(tickets);
        printResults(tickets, winningNumbers, bonusNumber);
    }

    private void printResults(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        Map<PrizeRank, Integer> resultMap = calculateResults(tickets, winningNumbers, bonusNumber);

        System.out.println("당첨 통계\n---");
        for (PrizeRank rank : PrizeRank.values()) {
            if (rank != PrizeRank.NONE) {
                System.out.printf("%d개 일치%s (%d원) - %d개%n",
                        rank.matchCount,
                        rank.bonusMatch ? ", 보너스 번호 일치" : "",
                        rank.getPrizeAmount(),
                        resultMap.getOrDefault(rank, 0));
            }
        }
    }

    public Map<PrizeRank, Integer> calculateResults(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        Map<PrizeRank, Integer> resultMap = new HashMap<>();

        for (Lotto ticket : tickets) {
            int matchCount = (int) ticket.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean bonusMatch = ticket.getNumbers().contains(bonusNumber);
            PrizeRank rank = PrizeRank.getRank(matchCount, bonusMatch);

            resultMap.put(rank, resultMap.getOrDefault(rank, 0) + 1);
        }
        return resultMap;
    }
}
