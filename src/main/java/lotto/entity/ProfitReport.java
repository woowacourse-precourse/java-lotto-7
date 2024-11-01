package lotto.entity;

import java.util.List;

public class ProfitReport {
    private final List<Lotto> purchasedLottos;
    private final WinningNumbers winningNumbers;

    public ProfitReport(List<Lotto> purchasedLottos, WinningNumbers winningNumbers) {
        if (purchasedLottos == null || purchasedLottos.isEmpty()) {
            throw new IllegalArgumentException("구매한 로또는 null 또는 비어있을 수 없습니다.");
        }
        if (winningNumbers == null) {
            throw new IllegalArgumentException("당첨 번호는 null일 수 없습니다.");
        }

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
