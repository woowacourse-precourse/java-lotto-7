package lotto.controller;

import lotto.Service.LottoService;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.UserNumber;
import lotto.model.UserNumbers;
import lotto.view.ViewFacade;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final ViewFacade viewFacade;
    private final LottoService service;

    public LottoController(ViewFacade viewFacade, LottoService service) {
        this.viewFacade = viewFacade;
        this.service = service;
    }

    public void run() {
        UserNumbers userNumbers = new UserNumbers(viewFacade.getPurchaseAmount());
        viewFacade.printUserLotto(userNumbers);
    }
}
