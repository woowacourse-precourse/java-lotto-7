package lotto.application.ticket.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.application.common.OutputPrinter;
import lotto.application.common.ThousandWons.ThousandWons;

public class TicketInputView {
    private final OutputPrinter printer;

    public TicketInputView() {
        this.printer = new OutputPrinter();
    }

    public ThousandWons initialize() {
        printer.appendWithLine("구입금액을 입력해 주세요.");
        printer.execute();
        String money = readLine();

        return ThousandWons.of(money);
    }


}
