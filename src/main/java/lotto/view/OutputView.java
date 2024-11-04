package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.PurchaseLotto;
import lotto.domain.WinningType;
import lotto.message.OutputMessage;

import java.util.List;

public class OutputView {

    public void purchaseLottoView(int lottoTickets, List<PurchaseLotto> purchaseLottos){
        System.out.println("\n" + lottoTickets + OutputMessage.PURCHASE_LOTTO.getMessage());
        for(PurchaseLotto purchaseLotto : purchaseLottos){
            System.out.println(purchaseLotto.getLottoNumbers());
        }
    }

    public void lottoResultView(LottoResult lottoResult, int purchaseAmount) {
        System.out.println("\n" + OutputMessage.WINNING_RESULT.getMessage());
        System.out.println("---");

        for (WinningType type : WinningType.values()) {
            int matchCount = lottoResult.getLottoResult().getOrDefault(type, 0);
            System.out.printf("%s - %d개%n", type.getMessage(), matchCount);
        }

        int totalPrize = lottoResult.calculateTotalPrize();
        double profitRate = calculateProfitRate(totalPrize, purchaseAmount);

        System.out.printf(OutputMessage.TOTAL_PROFIT_RATE.getMessage(), profitRate);
    }

    private double calculateProfitRate(int totalPrize, int purchaseAmount) {
        return ((double) totalPrize / purchaseAmount) * 100;
    }

}
