package lotto;

import java.util.List;

public class WinningResult {
    private final List<Lotto> tickets;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningResult(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        this.tickets = tickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void printResult() {
        // 당첨 결과 계산 및 출력 로직
    }
}
