package lotto;

import java.util.List;

public class LottoResult {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final List<Lotto> userLottos;

    public LottoResult(List<Integer> winningNumbers, int bonusNumber, List<Lotto> userLottos) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.userLottos = userLottos;
    }

    public void printResult() {
        // 등수 별로 당첨 내역 계산 및 수익률 출력
        int totalWinnings = calculateWinnings();
        double yield = calculateYield(totalWinnings);
        
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    private int calculateWinnings() {
        // 각 등수별 당첨 내역을 계산하는 로직을 구현
        return 0; // 예시이므로 실제 구현은 필요
    }

    private double calculateYield(int totalWinnings) {
        // 예시이므로 사용자가 로또에 소비한 총 금액과 수익률 계산
        return 0.0;
    }
}
