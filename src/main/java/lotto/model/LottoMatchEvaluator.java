package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMatchEvaluator {
    private List<LottoResult> lottoResults = new ArrayList<LottoResult>();

    public LottoMatchEvaluator(List<Integer> lottoNumber, int bonusNumber, LottoPublisher lottoPublisher) {
        evaluateLottoResults(lottoNumber, bonusNumber, lottoPublisher);
    }

    public void evaluateLottoResults(List<Integer> lottoNumber, int bonusNumber, LottoPublisher lottoPublisher) {
        List<List<Integer>> publishedLottos = lottoPublisher.getPublishedLotto();
        List<Integer> publishedBonus = lottoPublisher.getPublishedBonusLotto();
        boolean matchedBonus = false;

        for (int i = 0; i < publishedLottos.size(); i++) {
            int matchingLottoCount = (int) publishedLottos.get(i).stream().filter(lottoNumber::contains).count();

            if (matchingLottoCount < 3) { //매칭 갯수가 3보다 작으면 당첨권 밖이므로
                continue;
            }
            if (bonusNumber == publishedBonus.get(i)) {
                matchedBonus = true;
            }
            lottoResults.add(new LottoResult(matchingLottoCount, matchedBonus));
        }
    }

    public List<LottoResult> getLottoResults() {
        return lottoResults;
    }
}
