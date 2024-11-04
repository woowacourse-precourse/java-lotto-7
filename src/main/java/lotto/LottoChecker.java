package lotto;

import java.util.List;

public class LottoChecker {
    // 구매 금액을 인자로 받도록 수정합니다.
    public static LottoResult check(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {
        // LottoResult 객체 생성: 구매 금액을 전달합니다.
        LottoResult result = new LottoResult(purchaseAmount);

        // 각 로또 번호를 비교하여 당첨 등수를 추가합니다.
        for (Lotto lotto : purchasedLottos) {
            LottoRank rank = LottoRank.calculate(lotto, winningNumbers, bonusNumber);
            result.addRank(rank);
        }
        return result;
    }
}