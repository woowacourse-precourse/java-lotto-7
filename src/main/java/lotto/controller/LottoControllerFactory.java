package lotto.controller;

import lotto.service.LottoAdministratorService;
import lotto.service.LottoUserService;

public class LottoControllerFactory {

    public LottoController createLottoController() {
        LottoUserService userService = new LottoUserService();
        LottoAdministratorService administratorService = new LottoAdministratorService();

        return new LottoController(userService, administratorService);
    }
}
