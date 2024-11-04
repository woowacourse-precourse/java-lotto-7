package lotto.usecase.nneew.bonus;

import lotto.application.common.OutputPrinter;
import lotto.application.prize.domain.BonusNumber;
import lotto.application.prize.domain.WinnerNumbers;

public class CreateBonusNumberUsecase {
    private final BonusInputView inputView;
    private final BonusController controller;
    private final OutputPrinter printer;

    public CreateBonusNumberUsecase(BonusInputView inputView, BonusController controller) {
        this.inputView = inputView;
        this.controller = controller;
        this.printer = new OutputPrinter();
    }

    public BonusNumber execute(WinnerNumbers winNums) {
        while (true) {
            try {
                return tryExecute(winNums);
            } catch (IllegalArgumentException e) {
                printer.appendWithLine(e.getMessage());
                printer.execute();
            }
        }
    }

    private BonusNumber tryExecute(WinnerNumbers winNums) {
        BonusViewRequest request = inputView.initialize();
        return controller.create(winNums, request.bonusNumber());
    }

}
