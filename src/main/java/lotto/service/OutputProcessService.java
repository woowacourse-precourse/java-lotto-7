package lotto.service;

import lotto.converter.LottoConverter;
import lotto.dto.PurchaseResponse;
import lotto.dto.RateOfReturnResponse;
import lotto.dto.WinningResultResponse;
import lotto.model.Lotto;
import lotto.model.Purchase;
import lotto.model.WinningStandard;
import lotto.view.LottoOutputView;

import java.util.List;
import java.util.Map;

public class OutputProcessService {
    private final LottoOutputView lottoOutputView;
    private final LottoConverter lottoConverter;

    public OutputProcessService(LottoOutputView lottoOutputView, LottoConverter lottoConverter) {
        this.lottoOutputView = lottoOutputView;
        this.lottoConverter = lottoConverter;
    }

    public void printPurchaseLotto(Purchase purchase) {
        Integer lottoCount = purchase.getLottoCount();
        List<Lotto> lottos = purchase.getLottos();

        PurchaseResponse response = lottoConverter.convertToPurchaseResponse(lottoCount, lottos);

        lottoOutputView.printPurchaseLotto(response);
    }

    public void printWinningResult(Purchase purchase) {
        Map<Integer, Integer> winningResultStatistics = purchase.getWinningResultsStatistics();

        WinningResultResponse response = lottoConverter.convertToWinningResultResponse(winningResultStatistics);

        lottoOutputView.printWinningResult(response);
    }

    public void printRateOfReturn(Purchase purchase) {
        Float rateOfReturn = purchase.calculateRateOfReturn();

        RateOfReturnResponse response = lottoConverter.convertToRateOfReturnResponse(rateOfReturn);

        lottoOutputView.printRateOfReturn(response);
    }
}
