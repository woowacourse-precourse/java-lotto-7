package lotto.domain.lotto.presentation;

import java.util.List;
import lotto.domain.lotto.dto.request.LottoGameReq;
import lotto.domain.lotto.dto.response.LottoGameRes;
import lotto.domain.lotto.service.LottoService;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public List<List<Integer>> purchaseLottos(int amount) {
        return lottoService.purchaseLottos(amount);
    }

    public void playGame(List<List<Integer>> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoGameReq request = LottoGameReq.of(purchasedLottos, winningNumbers, bonusNumber);
        lottoService.createAndPlayGame(request);
    }

    public LottoGameRes getGameResult() {
        return lottoService.getGameResult();
    }
}
