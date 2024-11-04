package lotto.application.port.input;

import java.util.List;
import lotto.application.dto.request.EvaluateWinningLottoRequest;
import lotto.application.dto.response.EvaluateWinningLottoResponse;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningNumber;
import lotto.domain.lotto.vo.LottoPrize;

public interface EvaluateWinningLottoUsecase {

    EvaluateWinningLottoResponse execute(EvaluateWinningLottoRequest evaluateWinningLottoRequest);
}
