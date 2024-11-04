package lotto.application.dto.request;

import lotto.domain.lotto.WinningNumber;

public record EvaluateWinningLottoRequest(
    WinningNumber winningNumber
) {

}
