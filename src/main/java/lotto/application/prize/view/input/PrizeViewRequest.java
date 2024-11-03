package lotto.application.prize.view.input;

import java.util.List;

public record PrizeViewRequest(
        List<Integer> winnerNumbers,
        int bonusNumber) {
}
