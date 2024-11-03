package lotto.controller;

import java.util.List;
import lotto.service.prize.PrizeReadService;
import lotto.service.prize.PrizeWriteService;

public class PrizeController {
    private final PrizeWriteService writeService;
    private final PrizeReadService readService;

    public PrizeController(PrizeWriteService writeService, PrizeReadService readService) {
        this.writeService = writeService;
        this.readService = readService;
    }

    public Long save(List<Integer> numbers, int bonus) {
        return writeService.create(numbers, bonus);
    }

}
