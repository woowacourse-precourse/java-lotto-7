package lotto.controller;

import lotto.service.LottoUserService;

public class LottoControllerFactory {

    public LottoController createLottoController() {
        LottoUserService userService = new LottoUserService();

        return new LottoController(userService);
    }
}
