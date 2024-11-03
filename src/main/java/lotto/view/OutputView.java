package lotto.view;

import java.util.List;
import lotto.model.LottoRank;
import lotto.model.LottoResult;

public class OutputView {
    private final String LOTTO_COUNT_NOTICE = "개를 구매했습니다.";
    private final String LOTTO_RESULT_START_MESSAGE = "당첨 통계\n---";
    private static final String MATCHING_COUNT_MESSAGE = "개 일치";
    private static final String BONUS_LOTTO_MATCHING_MESSAGE = ", 보너스 볼 일치 ";
    private static final String COUNT_DELIMITER_MESSAGE = " - ";
    private static final String COUNT_UNIT = "개";
    private final LottoRank[] ranks = LottoRank.values();

    public void printPublishedLotto(List<List<Integer>> publishedLotto){
        int lottoCount = publishedLotto.size();
        System.out.println(lottoCount+LOTTO_COUNT_NOTICE);

        for(int i = 0; i < lottoCount; i++){
            System.out.println(publishedLotto.get(i));
        }
    }

    public void printOrderdLottoResult(List<Integer> lottoResult) {
        System.out.println(LOTTO_RESULT_START_MESSAGE);

        for (int i = ranks.length - 1; i >= 0; i--) {
                if(ranks[i].getMatchingBonus() == true){
                    System.out.println(ranks[i].getMatchingCount()+MATCHING_COUNT_MESSAGE+BONUS_LOTTO_MATCHING_MESSAGE+ranks[i].getPrizeNotice()+COUNT_DELIMITER_MESSAGE+lottoResult.get(i)+COUNT_UNIT);
                    continue;
                }
                System.out.println(ranks[i].getMatchingCount()+MATCHING_COUNT_MESSAGE+" "+ranks[i].getPrizeNotice()+COUNT_DELIMITER_MESSAGE+lottoResult.get(i)+COUNT_UNIT);
        }
    }

    public void printEarningRate() {

    }
}
