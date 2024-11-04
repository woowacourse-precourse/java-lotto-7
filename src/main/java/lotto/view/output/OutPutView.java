package lotto.view.output;

import lotto.dto.LottoResponse;
import lotto.dto.LottoResultResponse;

import java.util.List;

public interface OutPutView {
    public void displayPurchaseAmountPrompt();

    public void displayPurchaseCount(Integer purchaseCount);

    public void displayPurchaseLotto(List<LottoResponse> lottoResponses);

    public void displayWinningNumberPrompt();

    public void displayBonusNumberPrompt();

    public void displayLottoResults(LottoResultResponse lottoResultResponse);

    public void displayTotalReturnOfRate(Double rate);

    public void displayExceptionMessage(String exceptionMessage);
}
