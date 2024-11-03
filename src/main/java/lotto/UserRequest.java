package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.PurchaseLottos;
import lotto.domain.WinningLotto;
import lotto.dto.LottoGameDto;
import lotto.util.CallBackTemplate;
import lotto.viewHandler.ViewHandler;
import lotto.viewHandler.api.Api;
import lotto.viewHandler.api.dto.input.BonusNumberDto;
import lotto.viewHandler.api.dto.input.MoneyDto;
import lotto.viewHandler.api.dto.input.WinningLottoNumbersDto;
import lotto.viewHandler.api.message.ApiMessageImpl;
import lotto.viewHandler.exception.MyException;

import static lotto.viewHandler.exception.MyExceptionConstant.CLIENT_ERROR_CODE;

public class UserRequest {
    private final CallBackTemplate retry;
    private final LottoController lottoController;
    private final ViewHandler viewHandler;

    public UserRequest(CallBackTemplate retry, LottoController lottoController, ViewHandler viewHandler) {
        this.retry = retry;
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
        return retry.retry(
                () -> {
                    Api<WinningLottoNumbersDto> api = viewHandler.getWinningNumbers();
                    return lottoController.createWinningLotto(api.getData());
                },
                this::viewException
        );
    }

    private WinningLotto createWinningLottoDto(Lotto winningLotto) {
        return retry.retry(
                () -> {
                    Api<BonusNumberDto> api = viewHandler.getBonusNumber();
                    return lottoController.createWinningLottoDto(winningLotto, api.getData());
                },
                this::viewException
        );
    }

    private LottoGameDto createGameDto(PurchaseLottos lottos, WinningLotto winningLotto) {
        return lottoController.createGameDto(lottos, winningLotto);
    }

    private void viewApi(Api api) {
        viewHandler.outputHandler(api);
    }

    private void viewException(MyException e) {
        Api api = new Api(new ApiMessageImpl(e.getMessage(), CLIENT_ERROR_CODE));
        viewHandler.outputHandler(api);
    }
}
