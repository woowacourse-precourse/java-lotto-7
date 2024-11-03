package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    List<Lotto> myLotto;
    Lotto winningLotto;
    Integer bonusNumber;
    List<LottoResult> lottoResultList;
    Double profitRate;

    public LottoManager(List<Lotto> myLotto, Lotto winningLotto, Integer bonusNumber) {
        if (myLotto.isEmpty())
            throw new IllegalArgumentException("로또를 구매해야 합니다.");

        if (bonusNumber < 1 || bonusNumber > 45)
            throw new IllegalArgumentException("보너스 볼은 1부터 45까지의 숫자여야 합니다.");

        for(int i = 0; i < 6; i++){
            if (winningLotto.get(i) == bonusNumber)
                throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }

        this.myLotto = myLotto;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.lottoResultList = new ArrayList<>();
    }

    public Integer checkDefaultMatch(Lotto lotto){
        Integer matchCount = 0;
        for (int i = 0; i < 6; i++) {
            if (lotto.checkContains(winningLotto.get(i)))
                matchCount++;
        }
        return matchCount;
    }

    public Boolean checkBonusMatch(Lotto lotto){
        if (lotto.checkContains(bonusNumber))
            return true;
        return false;
    }

    public List<LottoResult> processResult() {
        if (!lottoResultList.isEmpty())
            return lottoResultList;
        for(Lotto lotto : myLotto) {
            Integer defaultMatchCount = this.checkDefaultMatch(lotto);
            Integer bonusMatchCount = 0;
            if(defaultMatchCount == 5 && this.checkBonusMatch(lotto))
                bonusMatchCount++;
            lottoResultList.add(LottoResult.fromMatchCounts(defaultMatchCount, bonusMatchCount));
        }
        return lottoResultList;
    }

    public Double calculateProfitRate() {
        return null;
    }

    public void printWinnigStatistics() {

    }
}


