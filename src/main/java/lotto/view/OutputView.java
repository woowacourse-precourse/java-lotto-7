package lotto.view;

import java.util.List;
import lotto.model.LottoGrade;
import lotto.model.LottoResult;

public class OutputView {
    public void printLottoCountOutput(int lottoCount) {
        String printMessage = "%d개를 구매했습니다.";
        System.out.println(String.format(printMessage, lottoCount));
    }

    public void printLottoOutput(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void printTotalWinningResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoGrade lottoGrade : LottoGrade.values()) {
            if (lottoGrade.getRanking() >= 6) {
                continue;
            }
            int gradeCount = lottoResult.getGradeCount(lottoGrade);
            System.out.println(makeLottoResultOutput(lottoGrade, gradeCount));
        }
    }

    public String makeLottoResultOutput(LottoGrade lottoGrade, int gradeCount) {
        String correctCountMessageFormat = "%d개 일치";
        String prizeMessageFormat = " (%,d원)";
        String totalCountMessageFormat = " - %d개";
        String bonusBallMessage = ", 보너스 볼 일치";

        String correctCountMessage = correctCountMessageFormat.formatted(lottoGrade.getCorrectCount());
        String prizeMessage = prizeMessageFormat.formatted(lottoGrade.getPrize());
        String totalCountMessage = totalCountMessageFormat.formatted(gradeCount);

        if (lottoGrade.getRanking() == 2) {
            return correctCountMessage + bonusBallMessage + prizeMessage + totalCountMessage;
        }
        return correctCountMessage + prizeMessage + totalCountMessage;
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }

}
