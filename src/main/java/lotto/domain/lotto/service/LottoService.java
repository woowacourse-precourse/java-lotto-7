package lotto.domain.lotto.service;

import java.util.List;
import lotto.domain.lotto.dto.request.LottoGameReq;
import lotto.domain.lotto.dto.response.LottoGameRes;

public interface LottoService {

    static LottoService getInstance() {
        return LottoServiceImpl.getInstance();
    }

    List<List<Integer>> purchaseLottos(int amount);

    void createAndPlayGame(LottoGameReq request);

    LottoGameRes getGameResult();
}
