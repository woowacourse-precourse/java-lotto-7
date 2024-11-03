package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.domain.Winning;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.WinningService;

public class LottoMachineController {

    private final User user = new User();
    private final Lottos lottos = new Lottos();
    private final Winning winning = new Winning();

    InputService inputService = new InputService(user);
    LottoService lottoService = new LottoService(user, lottos);
    WinningService winningService = new WinningService(lottos, winning);

    public void run() {
        inputService.run();
        lottoService.run();
        winningService.run();
    }
}
