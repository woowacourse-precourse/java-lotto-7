package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//  - 로또 결과에서 발행된 로또들과 당첨 번호를 비교한다
// 로또 결과 비교하기
// 수익률 계산하기
public class LottoResult {
    private final LottoStore lottoStore;
    private final LottoMachine lottoMachine;

    private Map<LottoRank, Integer> lottoResult;
    private int profitRate;

    public LottoResult(LottoStore lottoStore, LottoMachine lottoMachine) {
        this.lottoStore = lottoStore;
        this.lottoMachine = lottoMachine;
        lottoResultInitialize();
        calculateLottoResult();
        calculateProfitRate();
    }

    private void lottoResultInitialize() {
        for(LottoRank lottoRank : LottoRank.values()) {
            lottoResult.put(lottoRank, 0);
        }
    }

    private void calculateLottoResult() {
        List<Lotto> purchasedLottos = lottoStore.getLottos();
        List<Integer> winNumbers = lottoMachine.getWinNumbers();
        int bonusNumber = lottoMachine.getBonusNumber();

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

    private void calculateProfitRate() {

    }

    public Map<LottoRank, Integer> getLottoResult() {
        return this.lottoResult;
    }

    public float getProfitRate() {
        return this.profitRate;
    }
}
