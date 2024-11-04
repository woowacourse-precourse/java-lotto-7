package lotto.service;

import lotto.domain.LotteryDrawMachine;
import lotto.domain.LotteryNumberGenerator;
import lotto.domain.Lotto;
import lotto.domain.ROICalculator;
import lotto.domain.WinningCriteria;
import lotto.domain.WinningResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    public List<Lotto> purchaseLottoTickets(int totalSpent) {
        validatePurchaseAmount(totalSpent);
        int ticketCount = calculateTicketCount(totalSpent);
        return generateLottoTickets(ticketCount);
    }

    private void validatePurchaseAmount(int totalSpent) {
        if (totalSpent % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private int calculateTicketCount(int totalSpent) {
        return totalSpent / 1000;
    }

    private List<Lotto> generateLottoTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Lotto(LotteryNumberGenerator.generateRandomNumbers()));
        }
        return tickets;
    }

    public Map<String, Integer> checkWinnings(List<Lotto> tickets, List<Integer> jackpotNumbers, int bonusNumber) {
        LotteryDrawMachine drawMachine = new LotteryDrawMachine(jackpotNumbers, bonusNumber);
        Map<String, Integer> resultCounts = initializeResultCounts();
        calculateWinningCounts(tickets, drawMachine, resultCounts);
        return resultCounts;
    }

    private Map<String, Integer> initializeResultCounts() {
        Map<String, Integer> resultCounts = new HashMap<>();
        for (String label : WinningCriteria.getAllLabels()) {
            resultCounts.put(label, 0);
        }
        resultCounts.put("totalPrize", 0);
        return resultCounts;
    }


    private void calculateWinningCounts(List<Lotto> tickets, LotteryDrawMachine drawMachine, Map<String, Integer> resultCounts) {
        for (Lotto ticket : tickets) {
            WinningResult result = WinningVerifierService.verifyLotto(ticket, drawMachine);
            addWinningResult(result, resultCounts);
        }
    }

    private void addWinningResult(WinningResult result, Map<String, Integer> resultCounts) {
        WinningCriteria criteria = WinningCriteria.findMatchingCriteria(result.getMatchCount(), result.isBonusMatch());
        if (criteria != null) {
            incrementCount(resultCounts, criteria.getLabel(), criteria.getPrize());
        }
    }

    private void incrementCount(Map<String, Integer> resultCounts, String key, int prize) {
        resultCounts.put(key, resultCounts.get(key) + 1);
        resultCounts.put("totalPrize", resultCounts.get("totalPrize") + prize);
    }

    public double calculateROI(int totalSpent, int totalPrize) {
        return ROICalculator.calculate(totalSpent, totalPrize);
    }
}
