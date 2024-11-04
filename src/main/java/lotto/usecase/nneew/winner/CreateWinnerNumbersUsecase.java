package lotto.usecase.nneew.winner;

import lotto.application.common.OutputPrinter;
import lotto.application.prize.domain.WinnerNumbers;

public class CreateWinnerNumbersUsecase {
    private final WinnerInputView inputView;
    private final WinnerController controller;
    private final OutputPrinter printer;


    public CreateWinnerNumbersUsecase(WinnerInputView inputView, WinnerController controller) {
        this.inputView = inputView;
        this.controller = controller;
        this.printer = new OutputPrinter();
    }

    public WinnerNumbers execute() {
        while (true) {
            try {
                return tryExecute();
            } catch (IllegalArgumentException e) {
                printer.appendWithLine(e.getMessage());
                printer.execute();
            }

        }
    }

    private WinnerNumbers tryExecute() {
        WinnerViewRequest request = inputView.initialize();

        return controller.create(request.winNums());
    }
}
