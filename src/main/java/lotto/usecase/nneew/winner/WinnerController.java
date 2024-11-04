package lotto.usecase.nneew.winner;

import java.util.List;
import lotto.application.prize.domain.WinnerNumbers;

public class WinnerController {
    private final CreateWinnerNumbersService service;

    public WinnerController(CreateWinnerNumbersService service) {
        this.service = service;
    }

    public WinnerNumbers create(List<Integer> winNums) {
        return service.execute(winNums);
    }

}
존
