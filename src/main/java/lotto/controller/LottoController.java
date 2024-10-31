package lotto.controller;

import lotto.viewHandler.ViewHandler;
import lotto.viewHandler.api.Api;
import lotto.viewHandler.api.dto.BonusNumberDto;
import lotto.viewHandler.api.dto.InputDto;
import lotto.viewHandler.api.dto.MoneyDto;
import lotto.viewHandler.api.dto.WinningLottoNumbersDto;

public class LottoController {
    private final ViewHandler viewHandler;

    public LottoController(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
    }

    public void purchaseLotto() {
        Api<InputDto> inputDtoApi = viewHandler.inputHandler();
        InputDto inputDto = inputDtoApi.getData();
        MoneyDto moneyDto = inputDto.getMoneyDto();
        WinningLottoNumbersDto winningLottoNumbersDto = inputDto.getWinningLottoNumbersDto();
        BonusNumberDto bonusNumberDto = inputDto.getBonusNumberDto();
    }
}
