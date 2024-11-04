package lotto.View;

import java.util.List;
import java.util.Map;
import lotto.Enum.LottoWinningRank;

public class OutputView {
    private static final String LOTTO_RANK_THIRD = "5개 일치 (1,500,000원) - ";
    private static final String LOTTO_RANK_SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String LOTTO_RANK_FIRST = "6개 일치 (2,000,000,000원) - ";
    private static final String COUNT_UNIT = "개";
    private static final String EARNINGS_RATIO = "총 수익률은 ";
    private static final String EARNINGS_RATIO_SUFFIX = "입니다.";
    private static final String PURCHASE_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String LOTTO_WINNING_STATISTICS = "통계";
    private static final String DIVIDING_LINE = "---";
    private static final String LOTTO_RANK_FIFTH = "3개 일치 (5,000원) - ";
    private static final String LOTTO_RANK_FOURTH = "4개 일치 (50,000원) - ";

    public void printLottoWinningStatistics(Map<LottoWinningRank, Integer> lottoWinningRankMap) {
        System.out.println();
        System.out.println(LOTTO_WINNING_STATISTICS);
        System.out.println(DIVIDING_LINE);
        System.out.println(LOTTO_RANK_FIFTH + lottoWinningRankMap.get(LottoWinningRank.FIFTH) + COUNT_UNIT);
        System.out.println(LOTTO_RANK_FOURTH + lottoWinningRankMap.get(LottoWinningRank.FOURTH) + COUNT_UNIT);
        System.out.println(LOTTO_RANK_THIRD + lottoWinningRankMap.get(LottoWinningRank.THIRD) + COUNT_UNIT);
        System.out.println(LOTTO_RANK_SECOND + lottoWinningRankMap.get(LottoWinningRank.SECOND) + COUNT_UNIT);
        System.out.println(LOTTO_RANK_FIRST + lottoWinningRankMap.get(LottoWinningRank.FIRST) + COUNT_UNIT);
    }

    public void printPurchaseLottoCount(int purchaseLottoCount) {
        System.out.println();
        System.out.println(purchaseLottoCount + PURCHASE_LOTTO_COUNT);
    }

    public void printIssuedLottoNumbers(List<List<Integer>> issuedLottoNumbers) {
        issuedLottoNumbers.forEach(issuedLottoNumber -> System.out.println(issuedLottoNumber.toString()));
        System.out.println();
    }


    public void printEarningsRatio(String earningsRatio) {
        System.out.println(EARNINGS_RATIO + earningsRatio + EARNINGS_RATIO_SUFFIX);
    }
}