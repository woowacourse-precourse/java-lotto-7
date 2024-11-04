package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<WinningType, Integer> lottoResult = new HashMap<>();

    /**
     * 유저가 구매한 로또와 당첨 번호를 계산 해주는 메서드
     * @param purchaseLottos 유저가 구매한 로또 번호
     * @param winningLotto 당첨 번호
     * @return 당첨 결과
     */
    public LottoResult(List<PurchaseLotto> purchaseLottos, Lotto winningLotto) {
        for (PurchaseLotto lotto : purchaseLottos) {
            int matchCount = calculateMatchCount(lotto.getLottoNumbers(), winningLotto.getNumbers());
            boolean bonusMatched = lotto.getLottoNumbers().contains(winningLotto.getNumbers().get(Lotto.BONUS_NUMBER_INDEX));
            WinningType winningType = WinningType.valueOf(matchCount, bonusMatched);

            if (winningType != null) {
                lottoResult.put(winningType, lottoResult.getOrDefault(winningType, 0) + 1);
            }
        }
    }

    /**
     * 보너스 번호를 제외한 당첨 번호가 일치한지 계산하는 메서드
     * @param lottoNumbers 유저가 구매한 로또 번호
     * @param winningNumbers 당첨 번호
     * @return 당천 번호와 일치한 갯수
     */
    private int calculateMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 당첨 수익을 계산 해주는 메서드
     * @return 총 수익
     */
    public int calculateTotalPrize() {
        return lottoResult.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public Map<WinningType, Integer> getLottoResult() {
        return lottoResult;
    }
}