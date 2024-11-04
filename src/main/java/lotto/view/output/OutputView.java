package lotto.view.output;

import lotto.view.response.LottoProfitResponse;
import lotto.view.response.LottoScoreResponses;
import lotto.view.response.PurchaseLottoResponse;

public interface OutputView {

    void printPurchasedLottos(PurchaseLottoResponse response);

    void printScores(LottoScoreResponses response);

    void printProfitRate(LottoProfitResponse response);
}

