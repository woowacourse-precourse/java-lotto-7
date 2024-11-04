package lotto.converter;

import lotto.dto.PurchaseResponse;
import lotto.dto.RateOfReturnResponse;
import lotto.dto.WinningResultResponse;
import lotto.model.Lotto;
import lotto.model.WinningStandard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoConverter {
    public PurchaseResponse convertToPurchaseResponse(Integer lottoCount, List<Lotto> lottos) {
        List<List<Integer>> purchaseLottos = new ArrayList<>();
        for(Lotto lotto : lottos){
            purchaseLottos.add(lotto.getNumbers());
        }

        return new PurchaseResponse(lottoCount, purchaseLottos);
    }

    public WinningResultResponse convertToWinningResultResponse(Map<Integer, Integer> winningResultsStatics) {
        return new WinningResultResponse(winningResultsStatics);
    }

    public RateOfReturnResponse convertToRateOfReturnResponse(Float rateOfReturn) {
        return new RateOfReturnResponse(rateOfReturn);
    }
}
