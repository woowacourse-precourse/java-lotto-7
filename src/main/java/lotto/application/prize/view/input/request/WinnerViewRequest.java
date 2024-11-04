package lotto.application.prize.view.input.request;

import java.util.List;

public record WinnerViewRequest(
        List<Integer> winNums
) {
}

