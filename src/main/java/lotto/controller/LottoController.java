package lotto.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoBuy;
import lotto.model.LottoResult;
import lotto.view.LottoView;

public class LottoController {
    public void run() {
        try {
            BigInteger amount = LottoView.inputPurchaseAmount();
            LottoBuy purchase = new LottoBuy(amount);
            LottoView.printPurchaseResult(purchase.getNumberOfLottos());

            List<Lotto> lottos = generateLottos(purchase.getNumberOfLottos().intValue());
            lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));

            List<Integer> winningNumbers = LottoView.inputWinningNumbers();
            int bonusNumber = LottoView.inputBonusNumber(winningNumbers);

            printLottoResults(lottos, winningNumbers, bonusNumber, amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.generate());
        }
        return lottos;
    }

    private void printLottoResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber,
                                   BigInteger amount) {
        int totalPrize = 0;
        int[] resultCounts = new int[LottoResult.values().length];

        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
            LottoResult result = LottoResult.valueOf(matchCount, matchBonus);
            resultCounts[result.ordinal()]++;
            totalPrize += result.getPrize();
        }

        LottoView.printLottoResults(resultCounts);
        LottoView.printProfitRate(totalPrize, amount);
    }

    public void testPrintLottoResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber,
                                      BigInteger amount) {
        printLottoResults(lottos, winningNumbers, bonusNumber, amount);
    }
}
