package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    private static final int RANK_COUNT = 6;
    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_END_NUM = 45;
    private static final int LOTTO_PRICE = 1000;

    private final List<Integer> allLottoNums = new ArrayList<>();
    private final Stats stats = new Stats();
    private List<Integer> winningNums;
    private int bonusNum;

    public void initMachine() {
        for (int i = LOTTO_START_NUM; i <= LOTTO_END_NUM; i++) {
            allLottoNums.add(i);
        }
    }

    public Lottos issueLottos(int purchaseAmount) {
        int purchaseCount = (purchaseAmount / LOTTO_PRICE);
        Lottos lottos = new Lottos();
        for (int i = purchaseCount; i > 0; i--) {
            lottos.addLotto(issueLotto());
        }
        return lottos;
    }

    private Lotto issueLotto() {
        Collections.shuffle(allLottoNums);
        return new Lotto(allLottoNums.subList(0, 6));
    }

    public void updateWinningNums(List<Integer> winningNums) {
        this.winningNums = winningNums;
    }

    public void updateBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }

    public void updateWinningDetail(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            decideWin(lotto);
        }
    }

    private void decideWin(Lotto lotto) {
        List<Integer> lottoNums = lotto.getNumbers();
        lottoNums.retainAll(winningNums);
        int matchingCount = lottoNums.size();

        if (matchingCount < 3) {
            return;
        }
        if (matchingCount == 5 && lottoNums.contains(bonusNum)) {
            stats.addWinningCount(matchingCount + "+");
            return;
        }
        stats.addWinningCount(String.valueOf(matchingCount));
    }

    public Map<String, Integer> getWinningDetail() {
        return stats.getWinningDetail();
    }
}
