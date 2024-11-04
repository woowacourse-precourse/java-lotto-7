package lotto.application.port.input;

import lotto.application.dto.request.EvaluateWinningLottoRequest;
import lotto.application.dto.response.EvaluateWinningLottoResponse;

public interface EvaluateWinningLottoUsecase {

    EvaluateWinningLottoResponse execute(EvaluateWinningLottoRequest evaluateWinningLottoRequest);
}
