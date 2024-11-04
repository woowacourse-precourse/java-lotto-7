package lotto;

import lotto.dto.request.LottoBonusNumberRequest;
import lotto.dto.request.LottoResultRequest;
import lotto.dto.response.LottoBuyResponse;
import lotto.dto.response.LottoResultResponse;

import java.util.function.Supplier;

public class LottoController {
    private final LottoModel lottoModel = new LottoModel();
    private final LottoView lottoView = new LottoView();

    public void buyLotto() {
        LottoBuyResponse buyLottoResult = getValidatedInput(() ->
                lottoModel.buyLotto(lottoView.moneyInput()));

        lottoView.randomLottoNumberOutput(buyLottoResult);
    }

    public void getLottoPrizeNumber() {
        Lotto lotto = getValidatedInput(() ->
                lottoModel.makeLotto(lottoView.lottoNumbersInput()));
        int bonusNumber = getValidatedInput(() ->
                lottoModel.getBonusNumber(new LottoBonusNumberRequest(lotto, lottoView.bonusNumberInput())));

        LottoResultResponse lottoResultResponse = lottoModel.lottoResult(new LottoResultRequest(lotto, bonusNumber));

        lottoView.lottoResultOutput(lottoResultResponse);
    }

    private <T> T getValidatedInput(Supplier<T> inputSupplier) {
        while (true) {
            try {

                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
