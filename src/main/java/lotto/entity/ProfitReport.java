package lotto.entity;

import java.util.List;

public class ProfitReport {
    private final int paymentAmount;
    private final List<Lotto> purchasedLottos;
    private final WinningNumbers winningNumbers;

    public ProfitReport(int paymentAmount, List<Lotto> purchasedLottos, WinningNumbers winningNumbers) {
        /**
         * Validation TODO
         * 1. paymetnAmout가 0 이하일 때
         * 2. purchasedLottos가 null일 때
         * 3. purchasedLottos의 크기가 0일 때
         * 4. winningNumbers가 null일 때
         * 5. winningNumbers의 크기가 0일 때
         */

        this.paymentAmount = paymentAmount;
        this.purchasedLottos = purchasedLottos;
        this.winningNumbers = winningNumbers;
    }

    /**
     * Feature TODO
     * - [ ] 수익률 계산
     * - [ ] 수익 계산
     * - [ ] 각 등수 별 당첨 횟수 계산
     *
     * - [ ] 투자 금액 (gettter)
     * - [ ] 당첨 번호 (getter)
     * - [ ] 구매한 로또 (getter)
     * - [ ] 각 로또별 당첨 여부 (getter)
     */
}
