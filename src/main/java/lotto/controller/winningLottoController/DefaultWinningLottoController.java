package lotto.controller.winningLottoController;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.WinningLotto;
import lotto.io.InputHandler;

public class DefaultWinningLottoController implements WinningLottoController {

    private final InputHandler inputHandler;

    public DefaultWinningLottoController(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    @Override
    public Lotto readWinningNumbers() {
        List<Integer> numbers = inputHandler.handleWinningNumbers();
        return Lotto.from(numbers);
    }

    @Override
    public WinningLotto createWinningLotto(Lotto winningNumbers) {
        int bonusNumber = inputHandler.handleBonusNumber();
        return WinningLotto.of(winningNumbers, bonusNumber);
    }
}
