package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGenerator lottoGenerator = new LottoGenerator();
        System.out.println(lottoGenerator);
        List<Lotto> lottos = lottoGenerator.getLottos();
        int purchaseAmount = lottoGenerator.getPurchaseAmount();

        WinningNumbers winningNumbers = new WinningNumbers();
        List<Integer> winningNums = winningNumbers.getWinningNumbers();
        int bonusNum = winningNumbers.getBonusNumber();

        LottoCalculator lottoCalculator = new LottoCalculator(winningNums, bonusNum, lottos, purchaseAmount);
        lottoCalculator.calculateResults();

    }
}
