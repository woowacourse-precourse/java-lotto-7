package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.service.WinningVerifierService;

public class Customer {
    private final int totalSpent;
    private final List<Lotto> tickets = new ArrayList<>();
    private int totalPrize = 0;

    public Customer(int totalSpent) {
        if (totalSpent % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        this.totalSpent = totalSpent;
        for (int i = 0; i < totalSpent / 1000; i++) {
            tickets.add(new Lotto(LotteryNumberGenerator.generateRandomNumbers()));
        }
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    public void checkWinning(LotteryDrawMachine drawMachine) {
        for (Lotto ticket : tickets) {
            WinningResult result = WinningVerifierService.verifyLotto(ticket, drawMachine);
            totalPrize += result.getPrize();
        }
    }

    public double calculateROI() {
        return totalSpent == 0 ? 0 : Math.round((totalPrize / (double) totalSpent) * 1000) / 10.0;
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
