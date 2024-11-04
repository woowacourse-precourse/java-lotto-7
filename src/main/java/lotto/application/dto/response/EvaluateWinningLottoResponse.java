package lotto.application.dto.response;

import java.util.List;
import lotto.domain.lotto.vo.LottoPrize;

public record EvaluateWinningLottoResponse(
    List<LottoPrize> lottoPrizes
) {

}
