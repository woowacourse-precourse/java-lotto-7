package lotto.controller;

import lotto.model.administrator.WinningLottoNumbersDto;
import lotto.model.user.LottoResultDto;
import lotto.service.LottoAdministratorService;
import lotto.service.LottoUserService;

public class LottoController {

    private final LottoUserService userService;
    private final LottoAdministratorService administratorService;

    public LottoController(LottoUserService userService, LottoAdministratorService administratorService) {
        this.userService = userService;
        this.administratorService = administratorService;
    }

    public LottoResultDto buyLotto(final String insertedMoney) {
        return userService.createLottoResult(insertedMoney);
    }

    public WinningLottoNumbersDto setWinningNumbers(String winningNumbers, String bonusNumber) {
        return administratorService.setUpWinningNumbers(winningNumbers, bonusNumber);
    }
}
