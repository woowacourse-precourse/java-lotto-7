package lotto.lotto.winning.infrastructure;

import lotto.lotto.winning.domain.WinningLotto;
import lotto.view.input.hanlder.domain.InputHandlerService;

public class WinningLottoCreator {
    private final InputHandlerService inputHandlerService;
    public WinningLottoCreator(InputHandlerService inputHandlerService) {
        this.inputHandlerService = inputHandlerService;
    }
    public WinningLotto create() {
        return inputHandlerService.retrieveReceive(WinningLotto::of);
    }
}
