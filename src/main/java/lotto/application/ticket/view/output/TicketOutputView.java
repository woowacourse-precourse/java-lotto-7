package lotto.application.ticket.view.output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.application.common.OutputPrinter;
import lotto.application.ticket.dto.TicketResponse;

public class TicketOutputView {

    private final LottoMessageFormatter formatter;
    private final OutputPrinter printer;

    public TicketOutputView() {
        this.formatter = new LottoMessageFormatter();
        this.printer = new OutputPrinter();
    }

    public void show(TicketResponse ticketResponse) {
        appendPurchaseCount(ticketResponse.lottosSize());
        appendLottoNumbers(ticketResponse.getLottosValue());
        printer.execute();
    }

    private void appendPurchaseCount(int count) {
        String message = formatter.formatPurchaseMessage(count);
        printer.appendLine();
        printer.appendWithLine(message);
    }

    private void appendLottoNumbers(List<List<Integer>> tickets) {
        tickets.stream()
                .map(ArrayList::new)
                .peek(Collections::sort)
                .map(formatter::formatLottoNumbers)
                .forEach(printer::appendWithLine);

        printer.appendLine();
    }

}
