package lotto;

import java.util.List;

/**
 * 당첨 결과를 계산하는 클래스
 */
public class LottoResultCalculator {

    /**
     * 구매한 로또들의 당첨 결과를 계산
     *
     * @param lottos 구매한 로또 목록
     * @param winningNumbers 당첨 번호 목록
     * @param bonusNumber 보너스 번호
     * @return 당첨 결과
     */
    public WinningResult calculateResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        WinningResult result = new WinningResult();
        for (Lotto lotto : lottos) {
            result.addResult(lotto.match(winningNumbers, bonusNumber));
        }
        return result;
    }

    /**
     * 전체 수익률을 계산
     *
     * @param result 당첨 결과
     * @param purchaseAmount 구매 금액
     * @return 수익률 (백분율)
     */
    public double calculateReturnRate(WinningResult result, int purchaseAmount) {
        long totalPrize = result.calculateTotalPrize();
        return (totalPrize * 100.0) / purchaseAmount;
    }
}
