package lotto.lotto.winning.infrastructure;

import lotto.lotto.winning.domain.WinningLotto;
import lotto.lotto.domain.WinningLottoCreatorService;
import lotto.view.input.hanlder.domain.InputHandlerService;

public class WinningLottoCreator implements WinningLottoCreatorService {
    private final InputHandlerService inputHandlerService;
    public WinningLottoCreator(InputHandlerService inputHandlerService) {
        this.inputHandlerService = inputHandlerService;
    }
    @Override
    public WinningLotto create() {
        return inputHandlerService.retrieveReceive(WinningLotto::of);
    }
}
