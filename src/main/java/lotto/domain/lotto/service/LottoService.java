package lotto.domain.lotto.service;

import lotto.domain.lotto.dto.request.LottoGameReq;
import lotto.domain.lotto.dto.response.LottoGameRes;

public interface LottoService {

    void createAndPlayGame(LottoGameReq request);

    LottoGameRes getGameResult();
}
