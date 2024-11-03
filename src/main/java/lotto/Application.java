package lotto;

import lotto.controller.LottoGameController;
import lotto.service.UserService;
import lotto.service.LottoService;
import lotto.service.StatService;

public class Application {
    public static void main(String[] args) {
        final UserService userService = new UserService();
        final LottoService lottoService = new LottoService();
        final StatService statService = new StatService();

        LottoGameController lottoGameController = new LottoGameController(userService, lottoService, statService);
        lottoGameController.run();
    }
}
