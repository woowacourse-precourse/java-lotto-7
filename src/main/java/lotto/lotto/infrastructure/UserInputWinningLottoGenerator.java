package lotto.lotto.infrastructure;

import lotto.lotto.domain.WinningLotto;
import lotto.lotto.service.WinningLottoCreatorService;
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
