package lotto.controller;

import lotto.model.dto.LottoResultDto;
import lotto.service.LottoUserService;

public class LottoController {

    private final LottoUserService userService;

    public LottoController(LottoUserService userService) {
        this.userService = userService;
    }

    public LottoResultDto buyLotto(final String insertedMoney) {
        return userService.createLottoResult(insertedMoney);
    }
}
