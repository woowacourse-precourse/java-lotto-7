package lotto;

import global.io.InputHandler;
import global.io.OutputHandler;

import java.util.List;
import java.util.Map;

public class LottoGame {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final LottoGenerator lottoGenerator;
    private final LottoRankManager LottoRankManager;

    public LottoGame(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.lottoGenerator = new LottoGenerator();
        this.LottoRankManager = new LottoRankManager();
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottoList = generateLottoTickets(purchaseAmount);
        displayPurchasedTickets(lottoList);

        List<Integer> winningNumbers = getWinningNumbers();
        LottoRankManager.setWinningNumbers(winningNumbers);

        Integer bonusNumber = getBonusNumber();
        LottoRankManager.setBonusNumber(bonusNumber);

        displayResults(LottoRankManager.evaluateLottoRanks(lottoList), lottoGenerator.getTotalSales(purchaseAmount));
    }

    private int getPurchaseAmount() {
        outputHandler.printMessage("구입금액을 입력해 주세요.");
        return inputHandler.getIntegerInput(1000);
    }

    private List<Lotto> generateLottoTickets(int purchaseAmount) {
        List<Lotto> lottoList = lottoGenerator.generateLottoList(purchaseAmount);
        outputHandler.printMessage(lottoList.size() + "개를 구매했습니다.");
        return lottoList;
    }

    private void displayPurchasedTickets(List<Lotto> lottoList) {
        lottoList.forEach(lotto -> outputHandler.printList(lotto.getNumbers()));
    }

    private List<Integer> getWinningNumbers() {
        outputHandler.printMessage("당첨 번호를 입력해 주세요.");
        return inputHandler.getIntegerListInput(6);
    }

    private Integer getBonusNumber() {
        outputHandler.printMessage("보너스 번호를 입력해 주세요.");
        return inputHandler.getIntegerInput(0);
    }

    private void displayResults(Map<LottoRank, Integer> results, int totalInvestment) {
        outputHandler.printMessage("당첨 통계\n---");
        displayLottoStatistics(results);

        int totalPrize = calculateTotalPrize(results);
        double revenueRate = LottoRevenue.calculateRevenueRate(totalInvestment, totalPrize);
        outputHandler.printMessage(String.format("총 수익률은 %.1f%%입니다.", revenueRate));
    }

    private void displayLottoStatistics(Map<LottoRank, Integer> results) {
        results.forEach((lottoRank, count) -> {
            String message = String.format("%s (%,d원) - %d개", lottoRank.getDescription(), lottoRank.getPrize(), count);
            outputHandler.printMessage(message);
        });
    }

    private int calculateTotalPrize(Map<LottoRank, Integer> results) {
        return results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
