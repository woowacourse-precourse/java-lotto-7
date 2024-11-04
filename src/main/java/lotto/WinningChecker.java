package lotto;

import java.util.Set;

public class WinningChecker {
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningChecker(Set<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    // Lotto 객체의 번호 리스트를 가져와 일치 여부를 체크
    public int checkWinning(Lotto ticket) {
        long matchCount = ticket.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();

        boolean bonusMatch = ticket.getNumbers().contains(bonusNumber);

        if (matchCount == 6) return 1;            // 1등: 6개 일치
        if (matchCount == 5 && bonusMatch) return 2; // 2등: 5개 + 보너스 일치
        if (matchCount == 5) return 3;              // 3등: 5개 일치
        if (matchCount == 4) return 4;              // 4등: 4개 일치
        if (matchCount == 3) return 5;              // 5등: 3개 일치
        return 0;                                   // 꽝: 2개 이하 일치
    }
}
