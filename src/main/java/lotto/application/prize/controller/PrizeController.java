package lotto.application.prize.controller;

import java.util.List;
import lotto.application.prize.dto.PrizeResponse;
import lotto.application.prize.service.PrizeReadService;
import lotto.application.prize.service.PrizeWriteService;

public class PrizeController {
    private final PrizeWriteService writeService;
    private final PrizeReadService readService;

    public PrizeController(PrizeWriteService writeService, PrizeReadService readService) {
        this.writeService = writeService;
        this.readService = readService;
    }

    public Long create(List<Integer> numbers, int bonus) {
        return writeService.create(numbers, bonus);
    }

    public PrizeResponse getPrize(Long prizeId) {
        return readService.getPrize(prizeId);
    }

}
