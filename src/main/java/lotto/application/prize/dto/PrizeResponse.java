package lotto.application.prize.dto;

import lotto.application.prize.domain.PrizeNumberResult;

public class PrizeResponse {

    private final PrizeNumberResult prizeNumberResult;

    public PrizeResponse(PrizeNumberResult prizeNumberResult) {
        this.prizeNumberResult = prizeNumberResult;
    }

    public static PrizeResponse from(PrizeNumberResult prizeNumberResult) {
        return new PrizeResponse(prizeNumberResult);
    }

    public PrizeNumberResult getPrizeNumberResult() {
        return prizeNumberResult;
    }
}
