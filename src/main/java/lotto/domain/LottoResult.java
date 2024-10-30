package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

//  - 로또 결과에서 발행된 로또들과 당첨 번호를 비교한다
// 로또 결과 비교하기
// 수익률 계산하기
public class LottoResult {
    private Map<LottoRank, Integer> lottoResult = new HashMap<>();
    private int profitRate;

    public LottoResult() {
        lottoResultInitialize();
    }

    private void lottoResultInitialize() {
        for(LottoRank lottoRank : LottoRank.values()) {
            lottoResult.put(lottoRank, 0);
        }
    }

    public void calculateLottoResult(List<Lotto> purchasedLottos, List<Integer> winNumbers, int bonusNumber) {
        for (Lotto lotto : purchasedLottos) {
            boolean hasBonus = false;
            int lottoScore = 0;

            if (lotto.getNumbers().contains(bonusNumber)) {
                hasBonus = true;
                lottoScore += 10;
            }
            List<Integer> temp = new ArrayList<>(lotto.getNumbers());
            temp.retainAll(winNumbers);
            lottoScore += temp.size();

            LottoRank rank = LottoRank.findRank(lottoScore);

            if (rank != null) {
                Integer i = lottoResult.get(rank);
                lottoResult.put(rank, ++i);
            }
        }
    }

    public void calculateProfitRate(int price) {
        int profit = lottoResult.entrySet()
            .stream()
            .filter(e -> e.getValue() == 0)
            .mapToInt(e -> e.getKey().getPrize() * e.getValue())
            .sum();

        profitRate = (profit / price) * 100;
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return this.lottoResult;
    }

    public float getProfitRate() {
        return this.profitRate;
    }
}
