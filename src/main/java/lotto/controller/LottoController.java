package lotto.controller;

import lotto.Service.LottoService;
import lotto.view.ViewFacade;

import java.util.List;

public class LottoController {
    private final ViewFacade viewFacade;
    private final LottoService service;

    public LottoController(ViewFacade viewFacade, LottoService service) {
        this.viewFacade = viewFacade;
        this.service = service;
    }

    public void run() {
        service.generateUserNumbers(viewFacade.getPurchaseAmount());
        viewFacade.printUserLotto(service.getUserNumbers());

        service.generateLotto(viewFacade.getLottoNumber());
        service.generateBonusNumber(viewFacade.getBonusNumber());

        List<Integer> result = service.calculateResult();
        double rate = service.calculateRate();
        viewFacade.printResult(result, rate);
    }
}
