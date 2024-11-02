package lotto;

import java.util.List;

// 로또 티켓의 당첨여부 확인후 해당되는 당첨금 결정
public class LottoPrizeChecker {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoPrizeChecker(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public String checkPrize(List<Integer> ticketNumbers) {
        long matches = ticketNumbers.stream().filter(winningNumbers::contains).count();
        boolean bonusMatch = ticketNumbers.contains(bonusNumber);

        if (matches == 6) return "1등 (2,000,000,000원)";
        if (matches == 5 && bonusMatch) return "2등 (30,000,000원)";
        if (matches == 5) return "3등 (1,500,000원)";
        if (matches == 4) return "4등 (50,000원)";
        if (matches == 3) return "5등 (5,000원)";
        return "미당첨";
    }
}