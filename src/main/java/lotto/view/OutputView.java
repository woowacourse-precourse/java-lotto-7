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
        for (Map.Entry<WinningRanking, Integer> entry : rankingResult.entrySet()) {
            WinningRanking ranking = entry.getKey();
            Integer count = entry.getValue();

            if (ranking.getMatchCount() == 5 && ranking.needBonusNumber()) {
                System.out.println(
                        ranking.getMatchCount() + "개 일치, 보너스 볼 일치 (" + ranking.getPrize() + "원) -" + count + "개");
                continue;
            }
            System.out.println(ranking.getMatchCount() + "개 일치 (" + ranking.getPrize() + "원) -" + count + "개");
        }
    }
}
