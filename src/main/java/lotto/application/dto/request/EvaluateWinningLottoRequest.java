package lotto.application.dto.request;

import java.util.UUID;
import lotto.domain.lotto.WinningNumber;

public record EvaluateWinningLottoRequest(
    WinningNumber winningNumber,
    UUID buyerId
) {

}
