package lotto.ui;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.LottoContainer;
import lotto.domain.LottoInfo;
import lotto.domain.LottoPayment;
import lotto.domain.Results;
import lotto.common.LottoResults;
import lotto.exception.LottoArgumentException;

public class OutputController {
    private final OutputUi outputUi;

    OutputController(final OutputUi outputUi) {
        this.outputUi = outputUi;
    }

    public void printPurchaseInfo() {
        outputUi.printWithLineBreak("구입금액을 입력해 주세요.");
    }

    public void printAllLotteries(final LottoContainer lottoContainer) {
        this.nextLine();
        outputUi.printWithLineBreak(lottoContainer.getSize() + "개를 구매했습니다.");
        final List<LottoInfo> infos = lottoContainer.getInfos();
        for (final LottoInfo lottoInfo : infos) {
            outputUi.printWithLineBreak(lottoInfo.lottoNumbers().toString());
        }
    }

    public void printToGetWinningNumberInput() {
        this.nextLine();
        outputUi.printWithLineBreak("당첨번호를 입력해주세요.");
    }

    public void printToGetBonusNumberInput() {
        this.nextLine();
        outputUi.printWithLineBreak("보너스 번호를 입력해 주세요.");
    }

    public void printStatisticResults(final Results results) {
        this.nextLine();
        outputUi.printWithLineBreak("당첨 통계");
        outputUi.printWithLineBreak("---");
        outputUi.printWithLineBreak(results.getStatistics(LottoResults.FIFTH).toString());
        outputUi.printWithLineBreak(results.getStatistics(LottoResults.FORTH).toString());
        outputUi.printWithLineBreak(results.getStatistics(LottoResults.THIRD).toString());
        outputUi.printWithLineBreak(results.getStatistics(LottoResults.SECOND).toString());
        outputUi.printWithLineBreak(results.getStatistics(LottoResults.FIRST).toString());
    }

    public void printProfitRatio(final Results results, final LottoPayment lottoPayment) {
        outputUi.printWithLineBreak(
                "총 수익률은 " + results.getProfitRatio(lottoPayment).setScale(1, BigDecimal.ROUND_HALF_UP) + "%입니다.");
    }

    public void printErrorMessage(final LottoArgumentException lottoArgumentException) {
        outputUi.printWithLineBreak(lottoArgumentException.getMessage());
    }

    private void nextLine() {
        outputUi.printWithLineBreak("");
    }
}
