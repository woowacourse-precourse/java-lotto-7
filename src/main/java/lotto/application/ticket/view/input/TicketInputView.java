package lotto.application.ticket.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.application.ticket.message.Message.INPUT_MONEY_MESSAGE;

import lotto.application.common.OutputPrinter;
import lotto.application.common.ThousandWons.ThousandWons;

public class TicketInputView {
    private final OutputPrinter printer;

    public TicketInputView() {
        this.printer = new OutputPrinter();
    }

    public ThousandWons initialize() {
        printer.appendWithLine(INPUT_MONEY_MESSAGE);
        printer.execute();
        return readMoney();
    }

    private ThousandWons readMoney() {
        while (true) {
            try {
                return ThousandWons.of(readLine());
            } catch (IllegalArgumentException e) {
                printer.appendWithLine(e.getMessage());
                printer.appendWithLine(INPUT_MONEY_MESSAGE);
                printer.execute();
            }
        }
    }

}
