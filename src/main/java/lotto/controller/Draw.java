package lotto.controller;

import static lotto.domain.ValueExtractor.countDuplicate;

import java.util.ArrayList;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;

public class Draw {
    WinningResult[] winningResults;
    int amount;
    int bonus;
    double rateOfReturn;
    ArrayList<Lotto> tickets;
    Lotto winningNumber;

    public Draw(int amount, ArrayList<Lotto> tickets, Lotto winningNumber, int bonus) {
        this.amount = amount;
        this.tickets = tickets;
        this.winningNumber = winningNumber;
        this.bonus = bonus;
        winningResults = WinningResult.values();
    }

    public void run() {
        for (Lotto ticket : tickets) {
            int matchCount = calculateMatchCount(ticket);
            boolean isContainBonus = containsBonusNumber(ticket);
            updateWinningResults(matchCount, isContainBonus);
        }
        printResult();
    }

    private int calculateMatchCount(Lotto ticket) {
        return countDuplicate(ticket.getNumbers(), winningNumber.getNumbers());
    }

    private boolean containsBonusNumber(Lotto ticket) {
        return ticket.getNumbers().contains(bonus);
    }

    private void updateWinningResults(int matchCount, boolean isContainBonus) {
        for (WinningResult winningResult : winningResults) {
            if (isMatchingWinningResult(winningResult, matchCount, isContainBonus)) {
                winningResult.addWinningCount(isContainBonus);
            }
        }
    }

    private boolean isMatchingWinningResult(WinningResult winningResult, int matchCount, boolean isContainBonus) {
        if (winningResult.getMatchCount() == matchCount) {
            if (matchCount == 5) {
                return winningResult.isBonus() == isContainBonus;
            }
            return true;
        }
        return false;
    }

    public void calculateRateOfReturn() {
        int totalPrize = calculateTotalPrize();
        rateOfReturn = ((double) totalPrize / amount) * 100;
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;
        for (WinningResult winningResult : winningResults) {
            totalPrize += winningResult.getTotalPrize();
        }
        return totalPrize;
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WinningResult winningResult : winningResults) {
            System.out.println(winningResult.getDesc());
        }
        calculateRateOfReturn();
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }
}
