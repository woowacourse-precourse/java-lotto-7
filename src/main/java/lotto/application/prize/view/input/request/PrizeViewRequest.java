package lotto.application.prize.view.input.request;

import java.util.List;

public record PrizeViewRequest(
        List<Integer> winnerNumbers,
        int bonusNumber) {
}
