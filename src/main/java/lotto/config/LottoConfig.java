package lotto.config;

import lotto.controller.GameController;
import lotto.controller.PurchaseController;
import lotto.controller.WinController;
import lotto.repository.LottoRepository;
import lotto.repository.LottoRepositoryImpl;
import lotto.repository.ResultRepository;
import lotto.repository.ResultRepositoryImpl;
import lotto.service.PurchaseService;
import lotto.service.WinService;

import java.util.ArrayList;

public class LottoConfig {
    private final GameController gameController;

    public LottoConfig() {
        LottoRepository lottoRepository = createLottoRepository();
        ResultRepository resultRepository = createResultRepository();
        PurchaseController purchaseController = new PurchaseController(new PurchaseService(lottoRepository));
        WinController winController = new WinController(new WinService(lottoRepository, resultRepository));

        gameController = new GameController(purchaseController, winController);
    }

    public void start(){
        gameController.run();
    }

    public LottoRepository createLottoRepository(){
        return new LottoRepositoryImpl(new ArrayList<>());
    }

    public ResultRepository createResultRepository(){
        return new ResultRepositoryImpl();
    }

}
