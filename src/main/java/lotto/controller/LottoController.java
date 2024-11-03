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
        viewFacade.printUserLotto(service.getUserNumbers()); //사용자에 입력한 값을 보여줘야 하네, service에게 요청할까 vs 바로 불러올까?

        service.generateLotto(viewFacade.getLottoNumber());
        service.generateBonusNumber(viewFacade.getBonusNumber());

        List<Integer> result = service.calculateResult();
    }
}
