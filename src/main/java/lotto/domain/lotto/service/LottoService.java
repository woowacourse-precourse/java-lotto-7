package lotto.domain.lotto.service;

import lotto.domain.lotto.dto.request.LottoGameReq;
import lotto.domain.lotto.domain.LottoResult;

public interface LottoService {

    void createAndPlayGame(LottoGameReq request);

    LottoResult getGameResult();
}
