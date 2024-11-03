package lotto.service.prize;

import java.util.List;
import lotto.domain.prize.PrizeNumberResult;

public class PrizeResponse {
    private final List<Integer> winnerNumbers;
    private final int bonusNumber;

    public PrizeResponse(List<Integer> winnerNumbers, int bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static PrizeResponse from(PrizeNumberResult prizeNumberResult) {
        return new PrizeResponse(
                prizeNumberResult.getWinnerNumbers(),
                prizeNumberResult.getBonusNumber()
        );
    }

}
