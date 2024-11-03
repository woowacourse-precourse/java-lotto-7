package lotto;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = LottoInput.getValidPurchasePrice();

        LottoManager manager = new LottoManager(purchaseAmount);

        LottoPrint.purchaseNumber(manager.getLottos().size(), manager.getLottos());

        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = LottoInput.getValidWinningNo();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusBall = LottoInput.getValidBonus(winningNumbers);

        Map<LottoRank, Integer> rankStatistics = LottoRankInit.getLottoRank();

        LottoProcess.statisticalWork(manager, winningNumbers, bonusBall, rankStatistics);

        LottoPrint.getTotalPrize(rankStatistics);
        LottoPrint.printGrossMargin(purchaseAmount);
    }
}