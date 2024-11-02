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

    public void outputLottoIssue(LottoIssue lottoIssue) {
        lottoView.printLine(OUTPUT_LOTTO_PURCHASE_MONEY_COUNT, lottoIssue.getLottos().size());
        lottoView.output(issueLottoMessageFormatter, lottoIssue);
    }

    public void outputLottoMatch(LottoMatch ranks) {
        lottoView.printLine(OUTPUT_LOTTO_MATCH_MESSAGE);
        lottoView.print(OUTPUT_LOTTO_MATCH_DELIMITER);
        lottoView.output(lottoRankMessageFormatter, ranks);
    }

    public void outputProfitPercent(double profitPercent) {
        lottoView.print(OUTPUT_LOTTO_TOTAL_PROFIT, profitPercent);
    }
}
