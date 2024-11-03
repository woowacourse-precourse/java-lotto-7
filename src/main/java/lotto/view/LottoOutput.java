package lotto.view;

import lotto.model.LottoTickets;
import lotto.model.WinningAnalysisReport;

public class LottoOutput {
    private static final String REPORT_TITLE = "당첨 통계";
    private static final String REPORT_DIVIDER = "---";
    private static final String TICKET_PURCHASE_MESSAGE_FORMAT = "%s개를 구매했습니다.";

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayReport(WinningAnalysisReport report) {
        displayMessage(REPORT_TITLE);
        displayMessage(REPORT_DIVIDER);
        displayMessage(report.toString());
    }

    public void displayLottoTickets(LottoTickets lottoTickets) {
        displayMessage(String.format(TICKET_PURCHASE_MESSAGE_FORMAT, lottoTickets.tickets().size()));
        displayMessage(lottoTickets.toString());
    }
}
