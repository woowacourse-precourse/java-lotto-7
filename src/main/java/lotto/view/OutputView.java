package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.enums.OutputMessage;
import lotto.enums.WinningRanking;

public class OutputView {
    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLottoCountMessage(String lottoCountMessage) {
        System.out.println(lottoCountMessage);
    }

    public void printLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getNumbers());
        }
        System.out.println();
    }

    public void printLottoWinningMessage() {
        System.out.println(OutputMessage.LOTTO_WINNING_MESSAGE.getMessage());
    }

    public void printRankingResult(Map<WinningRanking, Integer> rankingResult) {
        for (WinningRanking ranking : WinningRanking.values()) {
            Integer count = rankingResult.getOrDefault(ranking, 0);

            if (ranking == WinningRanking.FIVE_MATCH_BONUS) {
                System.out.println(
                        ranking.getMatchCount() + "개 일치, 보너스 볼 일치 (" + ranking.getKoreaFormatPrize() + "원) - " + count
                                + "개");
                continue;
            }

            System.out.println(
                    ranking.getMatchCount() + "개 일치 (" + ranking.getKoreaFormatPrize() + "원) - " + count + "개");
        }
    }

    public void printEarningRate(double earningRateResult) {
        System.out.println(OutputMessage.EARNING_RATE_RESULT_MESSAGE.getEarningRateResultMessage(earningRateResult));
    }
}
