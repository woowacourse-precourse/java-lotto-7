package lotto;

import lotto.domain.*;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = InputView.inputPurchaseAmount();
            int ticketCount = purchaseAmount / 1000;

            LottoGenerator generator = new LottoGenerator();
            List<Lotto> tickets = generator.generateTickets(ticketCount);

            OutputView.printPurchaseInfo(ticketCount);
            OutputView.printLottoTickets(tickets);

            List<Integer> winningNumbers = InputView.inputWinningNumbers();
            int bonusNumber = InputView.inputBonusNumber();

            WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

            Map<Rank, Integer> result = calculateResult(tickets, winningLotto);

            OutputView.printWinningResult(result);
            double profitRate = calculateProfitRate(result, purchaseAmount);
            OutputView.printProfitRate(profitRate);
        } catch (LottoException e) {
            OutputView.printError(e.getMessage());
            main(args); // 에러 발생 시 입력을 다시 받기 위해 재귀 호출
        }
    }

    private static Map<Rank, Integer> calculateResult(List<Lotto> tickets, WinningLotto winningLotto) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        for (Lotto ticket : tickets) {
            int matchCount = countMatches(ticket, winningLotto.getWinningNumbers());
            boolean hasBonus = ticket.getNumbers().contains(winningLotto.getBonusNumber());

            Rank rank = Rank.of(matchCount, hasBonus);
            result.put(rank, result.get(rank) + 1);
        }

        return result;
    }

    private static int countMatches(Lotto ticket, Lotto winningNumbers) {
        return (int) ticket.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }

    private static double calculateProfitRate(Map<Rank, Integer> result, int purchaseAmount) {
        long totalPrize = 0;
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) continue;
            totalPrize += (long) rank.getPrize() * result.get(rank);
        }
        return (double) totalPrize / purchaseAmount * 100;
    }
}
