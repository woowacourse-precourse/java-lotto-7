package lotto.view.output;

import java.util.List;
import lotto.dto.TicketResult;
import lotto.view.formatter.LottoMessageFormatter;
import lotto.view.printer.OutputPrinter;

public class TicketOutputView {

    private final LottoMessageFormatter formatter;
    private final OutputPrinter printer;

    public TicketOutputView() {
        this.formatter = new LottoMessageFormatter();
        this.printer = new OutputPrinter();
    }

    public void show(TicketResult ticketResult) {
        appendPurchaseCount(ticketResult.count());
        appendLottoNumbers(ticketResult.ticket());
        printer.execute();
    }

    private void appendPurchaseCount(int count) {
        String message = formatter.formatPurchaseMessage(count);
        printer.appendLine(message);
    }

    private void appendLottoNumbers(List<List<Integer>> tickets) {
        tickets.stream()
                .map(formatter::formatLottoNumbers)
                .forEach(printer::appendLine);
    }

}
