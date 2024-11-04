package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoDraw;
import lotto.domain.LottoResult;
import lotto.domain.MatchResult;
import lotto.domain.Payment;
import lotto.domain.ReturnRate;
import lotto.domain.enums.LottoRank;
import lotto.view.OutputView;

public class ResultController {

    public ResultController() {
    }

    public List<MatchResult> generateMatchResults(List<Lotto> purchasedLottos, LottoDraw lottoDraw) {
        return purchasedLottos.stream()
                .map(lotto -> MatchResult.of(lotto, lottoDraw))
                .collect(Collectors.toList());
    }

    public LottoResult generateLottoResult(List<MatchResult> matchResults) {
        return LottoResult.of(matchResults);
    }

    public void printLottoResult(LottoResult lottoResult) {

        EnumMap<LottoRank, Integer> lottoResultBoard = lottoResult.getRankResult();

        OutputView.printLottoResultMessagePrefix();
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                int resultCount = lottoResultBoard.get(rank);
                OutputView.printLottoResultMessage(rank,resultCount);
            }
        }
    }

    public void printTotalRate(Payment payment, LottoResult lottoResult) {
        int purchaseAmount = payment.getMoney();
        long totalPrize = lottoResult.calculateTotalPrize();

        ReturnRate returnRate = ReturnRate.of(purchaseAmount,totalPrize);
        OutputView.printTotalRateMessage(returnRate.getReturnRate());
    }
}
