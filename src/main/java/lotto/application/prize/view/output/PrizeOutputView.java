package lotto.application.prize.view.output;

import lotto.application.common.OutputPrinter;

public class PrizeOutputView {
    private final OutputPrinter printer;

    public PrizeOutputView() {
        this.printer = new OutputPrinter();
    }

    public void printError(String message) {
        printer.appendWithLine(message);
        printer.execute();
    }

}


