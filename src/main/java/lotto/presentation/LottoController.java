package lotto.presentation;

import lotto.application.Service;

public class LottoController {

    private final Service service;

    public LottoController(Service service) {
        this.service = service;
    }

    public void run() {
        service.buyLottoHandler();
        service.matchLottoHandler();
    }
}
