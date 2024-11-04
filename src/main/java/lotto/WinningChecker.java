package lotto;

import java.util.Set;

public class WinningChecker {
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningChecker(Set<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 중복되지 않은 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int checkWinning(Lotto ticket) {
        long matchCount = ticket.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        boolean bonusMatch = ticket.getNumbers().contains(bonusNumber);

        if (matchCount == 6) return 6; // 6개 일치
        if (matchCount == 5 && bonusMatch) return 5; // 5개 + 보너스 일치
        if (matchCount == 5) return 4; // 5개 일치
        if (matchCount == 4) return 3; // 4개 일치
        if (matchCount == 3) return 2; // 3개 일치
        return 0; // 2개 이하 일치
    }
}
