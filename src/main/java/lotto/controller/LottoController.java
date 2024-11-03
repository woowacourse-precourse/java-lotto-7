package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.LottoConfig;
import lotto.domain.Lotto;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {

    private static LottoController controller;

    private final LottoService service;

    private LottoController(LottoConfig config) {
        this.service = config.lottoService();
    }

    public static LottoController getInstance(LottoConfig config) {

        if(controller == null)
            controller = new LottoController(config);

        return controller;
    }

    public void run() {

        List<Lotto> lottos = service.buyLottos();
        service.setWinningNumbers();
        service.setBonusNumber();
        Console.close();

        service.calculateResult(lottos);
    }
}
