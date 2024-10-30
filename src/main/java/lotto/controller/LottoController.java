package lotto.controller;

import lotto.viewHandler.ViewHandler;
import lotto.viewHandler.api.Api;
import lotto.viewHandler.api.dto.InputDto;

public class LottoController {
    private final ViewHandler viewHandler;

    public LottoController(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
    }

    public void purchaseLotto() {
        Api<InputDto> inputDtoApi = viewHandler.inputHandler();

    }
}
