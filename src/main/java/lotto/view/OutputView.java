package lotto.view;

import java.util.List;
import lotto.constant.LottoConstant;
import lotto.model.LottoGrade;
import lotto.model.LottoResult;

public class OutputView {
    private final static String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private final static String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";
    private final static String WINNING_COUNT_MESSAGE = "%d개 일치";
    private final static String WINNING_PRIZE_MESSAGE = " (%,d원)";
    private final static String TOTAL_COUNT_MESSAGE = " - %d개";
    private final static String BONUS_BALL_MESSAGE = ", 보너스 볼 일치";
    private final static String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printInputDescribeMessage(String inputDescribeMessage) {
        System.out.println(inputDescribeMessage);
    }

    public void printLottoCountOutput(int lottoCount) {
        System.out.printf(LOTTO_COUNT_MESSAGE.formatted(lottoCount));
    }

    public void printLottoOutput(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void printTotalWinningResult(LottoResult lottoResult) {
        System.out.println(WINNING_STATISTICS_MESSAGE);

        for (LottoGrade lottoGrade : LottoGrade.values()) {
            if (lottoGrade.getRanking() > LottoConstant.LOTTO_MIN_PRIZE_RANKING) {
                continue;
            }
            int gradeCount = lottoResult.getGradeCount(lottoGrade);
            System.out.println(makeLottoResultOutput(lottoGrade, gradeCount));
        }
    }

    public String makeLottoResultOutput(LottoGrade lottoGrade, int gradeCount) {
        String correctCountMessage = WINNING_COUNT_MESSAGE.formatted(lottoGrade.getCorrectCount());
        String prizeMessage = WINNING_PRIZE_MESSAGE.formatted(lottoGrade.getPrize());
        String totalCountMessage = TOTAL_COUNT_MESSAGE.formatted(gradeCount);

        if (lottoGrade.getRanking() == LottoGrade.SECOND_GRADE.getRanking()) {
            return correctCountMessage + BONUS_BALL_MESSAGE + prizeMessage + totalCountMessage;
        }
        return correctCountMessage + prizeMessage + totalCountMessage;
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }

}
