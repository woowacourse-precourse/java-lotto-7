package lotto.ui;

import java.util.List;
import lotto.LottoContainer;
import lotto.LottoInfo;

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
}
