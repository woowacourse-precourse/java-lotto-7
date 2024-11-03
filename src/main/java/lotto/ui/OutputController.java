package lotto.ui;

import java.math.BigDecimal;
import java.util.List;
import lotto.LottoContainer;
import lotto.LottoInfo;
import lotto.LottoPayment;
import lotto.Results;
import lotto.common.LottoResult;

public class OutputController {
    private final OutputUi outputUi;

    public OutputController(final OutputUi outputUi) {
        this.outputUi = outputUi;
    }

    public void printPurchaseInfo() {
        outputUi.printWithLineBreak("구입금액을 입력해 주세요.");
    }

    public void printAllLotteries(final LottoContainer lottoContainer) {
        outputUi.printWithLineBreak(lottoContainer.getSize() + "개를 구매했습니다.");
        final List<LottoInfo> infos = lottoContainer.getInfos();
        for (final LottoInfo lottoInfo : infos) {
            outputUi.printWithLineBreak(lottoInfo.lottoNumbers().toString());
        }
    }

    public void printToGetWinningNumberInput() {
        outputUi.printWithLineBreak("당첨번호를 입력해주세요.");
    }

    public void printToGetBonusNumberInput() {
        outputUi.printWithLineBreak("보너스 번호를 입력해 주세요.");
    }

    public void printStatisticResults(final Results results) {
        outputUi.printWithLineBreak("당첨 통계");
        outputUi.printWithLineBreak("---");
        outputUi.printWithLineBreak(results.getStatistics(LottoResult.FIFTH).toString());
        outputUi.printWithLineBreak(results.getStatistics(LottoResult.FORTH).toString());
        outputUi.printWithLineBreak(results.getStatistics(LottoResult.THIRD).toString());
        outputUi.printWithLineBreak(results.getStatistics(LottoResult.SECOND).toString());
        outputUi.printWithLineBreak(results.getStatistics(LottoResult.FIRST).toString());
    }

    public void printProfitRatio(final Results results, final LottoPayment lottoPayment) {
        outputUi.printWithLineBreak(
                "총 수익률은 " + results.getProfitRatio(lottoPayment).setScale(1, BigDecimal.ROUND_HALF_UP) + "%입니다.");
    }
}
