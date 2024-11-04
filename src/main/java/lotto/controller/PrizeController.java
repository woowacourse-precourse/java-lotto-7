package lotto.controller;

import lotto.model.PrizeModel;
import lotto.service.PrizeService;

public class PrizeController {
    PrizeService service = new PrizeService();

    public void run() {
        PrizeModel.setPrizeNumbers(service.inputNumbers());
        PrizeModel.setBonusNumber(service.inputNumber());
    }
}
