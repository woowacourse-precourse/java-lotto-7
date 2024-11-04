package lotto.application.prize.controller;

import java.util.List;
import lotto.application.prize.domain.WinnerNumbers;
import lotto.application.prize.service.CreateWinnerNumbersService;

public class WinnerController {
    private final CreateWinnerNumbersService service;

    public WinnerController(CreateWinnerNumbersService service) {
        this.service = service;
    }

    public WinnerNumbers create(List<Integer> winNums) {
        return service.execute(winNums);
    }

}
