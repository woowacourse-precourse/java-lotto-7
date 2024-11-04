package lotto;

import lotto.service.*;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Application {
    private static final int TICKET_PRICE = 1000;
    private static final InputService inputService = new InputService();
    private static final OutputService outputService = new OutputService();
    private static final Separator separator = new Separator();
    private static final LottoService lottoService = new LottoService();

    public static void main(String[] args) {
        int bonusNumber = 0;
        int purchaseAmount = 0;
        String winningNumbers = null;
        List<Lotto> lottos = null;
        List<Integer> separatedNumbers = null;

        purchaseAmount = inputWithRetry(() -> inputService.inputPurchaseAmount(TICKET_PRICE));

        int purchaseCount = purchaseAmount / TICKET_PRICE;
        System.out.println();
        System.out.println(purchaseCount + "개를 구매했습니다.");

        lottos = inputWithRetry(() -> lottoService.createLotto(purchaseCount));
        outputService.printLottos(lottos);

        while (true) {
            try {
                winningNumbers = inputService.inputWinningNumbers();
                separatedNumbers = separator.separate(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("예외 발생: " + e.getMessage());
                System.out.println("다시 입력하세요\n");
            }
        }

        List<Integer> finalSeparatedNumbers = separatedNumbers;
        bonusNumber = inputWithRetry(() -> inputService.inputBonusNumber(finalSeparatedNumbers));

        WinningLotto winningLotto = new WinningLotto(separatedNumbers, bonusNumber);
        Map<Lotto, LottoRank> rankForEach = lottoService.checkWinning(lottos, winningLotto);
        Map<LottoRank, Integer> winningCountForEach = lottoService.countWinningRank(rankForEach);

        long totalPrize = lottoService.getTotalPrize(winningCountForEach);
        String profitRate = lottoService.getProfitRate(purchaseAmount, totalPrize);

        outputService.printWinningStatistics(winningCountForEach);
        outputService.printProfitRate(profitRate);
    }

    private static <T> T inputWithRetry(Supplier<T> inputFunction) {
        while (true) {
            try {
                return inputFunction.get();
            } catch (IllegalArgumentException e) {
                System.out.println("예외 발생: " + e.getMessage());
                System.out.println("다시 입력하세요\n");
            }
        }
    }
}
