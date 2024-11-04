package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constant;

import java.util.List;
import java.util.Map;

public class LottoMachine {
    private final Stats stats = new Stats();
    private List<Integer> winningNums;
    private int bonusNum;

    public Lottos issueLottos(int purchaseAmount) {
        int purchaseCount = (purchaseAmount / Constant.LOTTO_PRICE);
        Lottos lottos = new Lottos();
        for (int i = purchaseCount; i > 0; i--) {
            Lotto lotto = issueLotto();
            lottos.addLotto(lotto);
        }
        return lottos;
    }

    private Lotto issueLotto() {
        List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(Constant.LOTTO_START_NUM, Constant.LOTTO_END_NUM, Constant.LOTTO_NUM_COUNT);
        lottoNums.sort(Integer::compareTo);
        return new Lotto(lottoNums);
    }

    public void updateWinningNums(List<Integer> winningNums) {
        this.winningNums = winningNums;
    }

    public void updateBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }

    public void updateWinningDetail(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            decideMatchState(lotto);
        }
    }

    private void decideMatchState(Lotto lotto) {
        List<Integer> lottoNums = lotto.getNumbers();
        lottoNums.retainAll(winningNums);
        int matchingCount = lottoNums.size();

        if (matchingCount < 3) {
            return;
        }

        stats.addWinningCount(LottoMatchState.getMatchState(matchingCount, lottoNums.contains(bonusNum)));
    }

    public Map<LottoMatchState, Integer> getWinningDetail() {
        return stats.getWinningDetail();
    }

    public double getProfitRate(int purchaseAmount) {
        return stats.getProfitRate(purchaseAmount);
    }
}
