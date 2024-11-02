package lotto.service;

import lotto.domain.LottoIssue;
import lotto.domain.LottoMatch;
import lotto.format.LottoIssueMessageFormatter;
import lotto.format.LottoMatchMessageFormatter;
import lotto.format.MessageFormatter;
import lotto.view.LottoView;

import static lotto.message.OutputMessage.*;

public class LottoOuputService {

    private final LottoView lottoView;
    private final MessageFormatter<LottoIssue> issueLottoMessageFormatter;
    private final MessageFormatter<LottoMatch> lottoRankMessageFormatter;

    public LottoOuputService(LottoView lottoView) {
        this.lottoView = lottoView;
        this.lottoRankMessageFormatter = new LottoMatchMessageFormatter();
        this.issueLottoMessageFormatter = new LottoIssueMessageFormatter();
    }

    public void outputIssueLotto(LottoIssue lottoIssue) {
        lottoView.println(OUTPUT_PURCHASE_COUNT, lottoIssue.getLottos().size());
        lottoView.output(issueLottoMessageFormatter, lottoIssue);
    }

    public void outPutLottoRank(LottoMatch ranks) {
        lottoView.println(OUTPUT_LOTTO_STATISTIC);
        lottoView.print(OUTPUT_LOTTO_STATISTIC_DELIMITER);
        lottoView.output(lottoRankMessageFormatter, ranks);
    }

    public void outPutProfitPercent(double profitPercent) {
        lottoView.print(OUTPUT_TOTAL_PROFIT, profitPercent);
    }
}
