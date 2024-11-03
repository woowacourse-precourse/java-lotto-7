package lotto.view;

import lotto.service.domain.lotto.LottoReward;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.service.domain.lotto.Lotto;
import lotto.service.domain.lotto.LottoReward;
import lotto.service.domain.statistics.StatisticsReport;

public class OutputHandler {
    private final String OUTPUT_PURCHASEDLOTTO_FORM = "%d개를 구매했습니다.";
    private final String OUTPUT_RESULT_INTRO = "당첨 통계";
    private final String OUTPUT_RESULT_LINE = "---";
    private final String OUTPUT_RESULT_FORM = "%d개 일치 (%s원) - %d개";
    private final String OUTPUT_RESULT_RATE_FORM = "총 수익률은 %.1f%%입니다.";

    private Printer printer = new Printer();

    public void printPurchasedLotto(List<Lotto> purchasedLotto) {
        printer.printStringFormatMessage(OUTPUT_PURCHASEDLOTTO_FORM, purchasedLotto.size());

        purchasedLotto.stream()
                .map(lottoTicket -> lottoTicket.getLottoticket().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(",", "[", "]")))
                .forEach(lottoTicketString -> printer
                        .printStringFormatMessage("%s", lottoTicketString));
    }

    public void printStatisticsReport(StatisticsReport statisticsReport) {
        printer.printMessage(OUTPUT_RESULT_INTRO);
        printer.printMessage(OUTPUT_RESULT_LINE);

        statisticsReport.getCountLottoReward().entrySet().stream()
                .filter(each -> each.getKey() != LottoReward.FAIL)
                .forEach(each -> printer
                        .printStringFormatMessage(OUTPUT_RESULT_FORM
                                , each.getKey().getRequiredMatch()
                                , each.getKey().getPrize()
                                , each.getValue()));
        printer.printStringFormatMessage(OUTPUT_RESULT_RATE_FORM, statisticsReport.getProfitRate());

    }
}
