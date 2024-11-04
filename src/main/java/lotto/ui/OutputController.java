package lotto.ui;

import java.math.BigDecimal;
import java.util.List;
import lotto.common.LottoResults;
import lotto.domain.LottoContainer;
import lotto.domain.LottoInfo;
import lotto.domain.LottoPayment;
import lotto.domain.Results;
import lotto.exception.LottoArgumentException;

public class OutputController {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨번호를 입력해주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String TOTAL_PROFIT_AMOUNT_FORM = "총 수익률은 %s%%입니다.";
    private static final String STATISTIC_INFO_MESSAGE = "당첨 통계";
    private static final String LINE_SEPARATOR = "---";
    private static final String BLANK = "";

    private final OutputUi outputUi;

    OutputController(final OutputUi outputUi) {
        this.outputUi = outputUi;
    }

    public void printPurchaseInfo() {
        outputUi.printWithLineBreak(PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public void printAllLotteries(final LottoContainer lottoContainer) {
        this.nextLine();
        outputUi.printWithLineBreak(String.format(LOTTO_COUNT_FORMAT, lottoContainer.getSize()));
        final List<LottoInfo> infos = lottoContainer.getInfos();
        for (final LottoInfo lottoInfo : infos) {
            outputUi.printWithLineBreak(lottoInfo.lottoNumbers().toString());
        }
    }

    public void printToGetWinningNumberInput() {
        this.nextLine();
        outputUi.printWithLineBreak(WINNING_NUMBER_INPUT_MESSAGE);
    }

    public void printToGetBonusNumberInput() {
        this.nextLine();
        outputUi.printWithLineBreak(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void printStatisticResults(final Results results) {
        this.nextLine();
        outputUi.printWithLineBreak(STATISTIC_INFO_MESSAGE);
        outputUi.printWithLineBreak(LINE_SEPARATOR);
        outputUi.printWithLineBreak(results.getStatistics(LottoResults.FIFTH).toString());
        outputUi.printWithLineBreak(results.getStatistics(LottoResults.FORTH).toString());
        outputUi.printWithLineBreak(results.getStatistics(LottoResults.THIRD).toString());
        outputUi.printWithLineBreak(results.getStatistics(LottoResults.SECOND).toString());
        outputUi.printWithLineBreak(results.getStatistics(LottoResults.FIRST).toString());
    }

    public void printProfitRatio(final Results results, final LottoPayment lottoPayment) {
        final String ratio = results.getProfitRatio(lottoPayment).setScale(1, BigDecimal.ROUND_HALF_UP).toString();
        outputUi.printWithLineBreak(String.format(
                TOTAL_PROFIT_AMOUNT_FORM,
                ratio)
        );
    }

    public void printErrorMessage(final LottoArgumentException lottoArgumentException) {
        outputUi.printWithLineBreak(lottoArgumentException.getMessage());
    }

    private void nextLine() {
        outputUi.printWithLineBreak(BLANK);
    }
}
