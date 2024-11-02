package lotto;

import java.util.List;
import java.util.Set;

public class WinningChecker {
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningChecker(Set<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int checkWinning(List<Integer> ticketNumbers) {
        long matchCount = ticketNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean bonusMatch = ticketNumbers.contains(bonusNumber);

        if (matchCount == 6) return 6; // 6개 일치
        if (matchCount == 5 && bonusMatch) return 5; // 5개 + 보너스 일치
        if (matchCount == 5) return 4; // 5개 일치
        if (matchCount == 4) return 3; // 4개 일치
        if (matchCount == 3) return 2; // 3개 일치
        return 0; // 2개 이하 일치
    }
}
