package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMatchEvaluator {
    private List<LottoResult> lottoResults = new ArrayList<>();
    private final List<Integer> lottoWinningCounts = new ArrayList<Integer>();

    public LottoMatchEvaluator(List<Integer> lottoNumber, int bonusNumber, LottoPublisher lottoPublisher) {
        matchLottoNumbers(lottoNumber, bonusNumber, lottoPublisher);
    }

    public void matchLottoNumbers(List<Integer> lottoNumber, int bonusNumber, LottoPublisher lottoPublisher) {
        List<List<Integer>> publishedLottos = lottoPublisher.getPublishedLotto();
        boolean matchedBonus = false;

        for (int i = 0; i < publishedLottos.size(); i++) {
            int matchingLottoCount = (int) publishedLottos.get(i).stream().filter(lottoNumber::contains).count();

            if (matchingLottoCount < 3) { //매칭 갯수가 3보다 작으면 당첨권 밖이므로
                continue;
            }
            if (publishedLottos.get(i).contains(bonusNumber)) {
                matchedBonus = true;
            }
            lottoResults.add(new LottoResult(matchingLottoCount, matchedBonus));
        }
    }

    public List<Integer> getLottoWinningCounts() {
        LottoRank[] ranks = LottoRank.values();

        for (int i = 0; i < ranks.length; i++) {
            int rankMatchingcount = ranks[i].getMatchingCount();
            int lottoWinningCount = (int) lottoResults.stream()
                    .filter(lotto -> lotto.getMatchingCount() == rankMatchingcount).count();

            if (ranks[i].getMatchingBonus()) { //5개 일치인데 보너스 번호가 일치하는 경우
                int bonusWinnigCount = (int) lottoResults.stream()
                        .filter(lotto -> lotto.isMatchingBonus() && lotto.getMatchingCount() == rankMatchingcount)
                        .count();
                lottoWinningCounts.add(bonusWinnigCount);
                continue;
            }

            lottoWinningCounts.add(lottoWinningCount);
        }
        return lottoWinningCounts;
    }
}
