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
        List<Number> numbers = inputHandler.handleWinningNumbers().stream()
                .map(Number::new)
                .toList();
        return new Lotto(numbers);
    }

    @Override
    public WinningLotto createWinningLotto(Lotto winningNumbers) {
        int bonusNumber = inputHandler.handleBonusNumber();
        return new WinningLotto(winningNumbers, new Number(bonusNumber));
    }
}
