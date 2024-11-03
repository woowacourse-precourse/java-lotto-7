package lotto.model;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers; // 당첨 번호 리스트
    private final int bonusNumber;              // 보너스 번호

    // 생성자 - 당첨 번호와 보너스 번호로 초기화
    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        // validate(winningNumbers, bonusNumber); // 유효성 검사 메서드
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    // 당첨 번호 리스트 반환
    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    // 보너스 번호 반환
    public int getBonusNumber() {
        return bonusNumber;
    }
}
