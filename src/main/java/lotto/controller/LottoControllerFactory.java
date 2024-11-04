package lotto.controller;

import lotto.service.LottoAdministratorService;
import lotto.service.LottoUserService;

public class LottoControllerFactory {

    public LottoController createLottoController() {
        final LottoUserService userService = new LottoUserService();
        final LottoAdministratorService administratorService = new LottoAdministratorService();

        return new LottoController(userService, administratorService);
    }
}
