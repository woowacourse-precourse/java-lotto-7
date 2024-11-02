package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.PurchaseLottos;
import lotto.domain.WinningLotto;
import lotto.dto.LottoGameDto;
import lotto.dto.output.PurchaseLottosDto;
import lotto.viewHandler.ViewHandler;
import lotto.viewHandler.api.Api;
import lotto.viewHandler.api.dto.input.BonusNumberDto;
import lotto.viewHandler.api.dto.input.MoneyDto;
import lotto.viewHandler.api.dto.input.WinningLottoNumbersDto;
import lotto.viewHandler.api.message.ApiMessageImpl;
import lotto.viewHandler.api.message.ServerMessage;
import lotto.viewHandler.exception.MyException;

public class UserRequest {
    private final LottoController lottoController;
    private final ViewHandler viewHandler;

    public UserRequest(LottoController lottoController, ViewHandler viewHandler) {
        this.lottoController = lottoController;
        this.viewHandler = viewHandler;
    }

    public void runLotto() {
        PurchaseLottos purchaseLottos = purchaseLottos();
        viewApi(lottoController.viewPurchaseLotto(purchaseLottos));

        Lotto winningLotto = createWinningLotto();
        WinningLotto winningLottoDto = createWinningLottoDto(winningLotto);

        lottoController.runLottoGame(createGameDto(purchaseLottos, winningLottoDto));

        viewApi(lottoController.viewResultLottos());
        viewApi(lottoController.viewResultAmount(purchaseLottos));
    }

    private PurchaseLottos purchaseLottos() {
        Api<MoneyDto> api = viewHandler.purchaseMoney();
        return lottoController.purchaseLotto(api.getData());
    }

    private Lotto createWinningLotto() {
        while (true) {
            try {
                Api<WinningLottoNumbersDto> api = viewHandler.getWinningNumbers();
                return lottoController.createWinningLotto(api.getData());
            } catch (MyException e) {
                viewApi(new Api<>(new ApiMessageImpl(e.getMessage(), 400)));
            }
        }
    }

    private WinningLotto createWinningLottoDto(Lotto winningLotto) {
        while (true) {
            try {
                Api<BonusNumberDto> api = viewHandler.getBonusNumber();
                return lottoController.createWinningLottoDto(winningLotto, api.getData());
            } catch (MyException e) {
                viewApi(new Api<>(new ApiMessageImpl(e.getMessage(), 400)));
            }
        }
    }

    private LottoGameDto createGameDto(PurchaseLottos lottos, WinningLotto winningLotto) {
        return lottoController.createGameDto(lottos, winningLotto);
    }

    private void viewApi(Api api) {
        viewHandler.outputHandler(api);
    }
}
