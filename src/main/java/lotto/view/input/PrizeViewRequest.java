package lotto.view.input;

import java.util.List;

public record PrizeViewRequest(
        List<Integer> prizeNumber,
        int bonusNumber) {
}
