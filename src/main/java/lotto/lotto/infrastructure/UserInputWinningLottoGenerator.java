package lotto.lotto.infrastructure;

import lotto.lotto.domain.WinningLotto;
import lotto.lotto.service.WinningLottoGenerator;
import lotto.view.input.hanlder.domain.InputHandlerService;

public class UserInputWinningLottoGenerator implements WinningLottoGenerator {
    private final InputHandlerService inputHandlerService;
    public UserInputWinningLottoGenerator(InputHandlerService inputHandlerService) {
        this.inputHandlerService = inputHandlerService;
    }
    @Override
    public WinningLotto create() {
        return inputHandlerService.retrieveReceive(WinningLotto::of);
    }
}
