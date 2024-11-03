package lotto;

import java.util.List;
import java.util.Map;

public class LottoRunner {
    public static void run() {
        int purchaseAmount = getPurchaseAmount();
        LottoManager manager = new LottoManager(purchaseAmount);
        printPurchasedLottos(manager);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusBall = getBonusBall(winningNumbers);

        Map<LottoRank, Integer> rankStatistics = initializeRankStatistics();
        processStatistics(manager, winningNumbers, bonusBall, rankStatistics);
        printResults(purchaseAmount, rankStatistics);
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return LottoInput.getValidPurchasePrice();
    }

    private static void printPurchasedLottos(LottoManager manager) {
        LottoPrint.purchaseNumber(manager.getLottos().size(), manager.getLottos());
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return LottoInput.getValidWinningNo();
    }

    private static int getBonusBall(List<Integer> winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return LottoInput.getValidBonus(winningNumbers);
    }

    private static Map<LottoRank, Integer> initializeRankStatistics() {
        return LottoRankInit.getLottoRank();
    }

    private static void processStatistics(LottoManager manager, List<Integer> winningNumbers, int bonusBall, Map<LottoRank, Integer> rankStatistics) {
        LottoProcess.statisticalWork(manager, winningNumbers, bonusBall, rankStatistics);
    }

    private static void printResults(int purchaseAmount, Map<LottoRank, Integer> rankStatistics) {
        LottoPrint.getTotalPrize(rankStatistics);
        LottoPrint.printGrossMargin(purchaseAmount);
    }
}
