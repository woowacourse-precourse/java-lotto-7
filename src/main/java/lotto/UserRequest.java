package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.PurchaseLottos;
import lotto.domain.WinningLotto;
import lotto.dto.LottoGameDto;
import lotto.viewHandler.ViewHandler;
import lotto.viewHandler.api.Api;
import lotto.viewHandler.api.dto.input.BonusNumberDto;
import lotto.viewHandler.api.dto.input.MoneyDto;
import lotto.viewHandler.api.dto.input.WinningLottoNumbersDto;

public class UserRequest {
    private final LottoController lottoController;
    private final ViewHandler viewHandler;

    public UserRequest(LottoController lottoController, ViewHandler viewHandler) {
        this.lottoController = lottoController;
        this.viewHandler = viewHandler;
    }

    public void runLotto() {
        PurchaseLottos purchaseLottos = purchaseLottos();
        Lotto winningLotto = createWinningLotto();
        WinningLotto winningLottoDto = createWinningLottoDto(winningLotto);

        lottoController.runLottoGame(createGameDto(purchaseLottos, winningLottoDto));
    }

    private PurchaseLottos purchaseLottos() {
        Api<MoneyDto> api = viewHandler.purchaseMoney();
        return lottoController.purchaseLotto(api.getData());
    }

    private Lotto createWinningLotto() {
        Api<WinningLottoNumbersDto> api = viewHandler.getWinningNumbers();
        return lottoController.createWinningLotto(api.getData());
    }

    private WinningLotto createWinningLottoDto(Lotto winningLotto) {
        Api<BonusNumberDto> api = viewHandler.getBonusNumber();
        return lottoController.createWinningLottoDto(winningLotto, api.getData());
    }

    private LottoGameDto createGameDto(PurchaseLottos lottos, WinningLotto winningLotto) {
        return lottoController.createGameDto(lottos, winningLotto);
    }
}
