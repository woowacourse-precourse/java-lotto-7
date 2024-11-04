package lotto.handler;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import lotto.view.InputView;

public class BonusNumberOperation implements Operation<WinningNumber> {

    private final InputView inputView;
    private final WinningNumber winningNumber;

    public BonusNumberOperation(InputView inputView, WinningNumber winningNumber) {
        this.inputView = inputView;
        this.winningNumber = winningNumber;
    }

    @Override
    public WinningNumber execute() throws IllegalArgumentException {
        int bonusNumber = inputView.insertNumber();
        winningNumber.addBonusNumber(new BonusNumber(bonusNumber));
        return winningNumber;
    }
}
