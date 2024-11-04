package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        int purchaseAmount = userInput.readPurchaseAmount();

        LottoCount lottoCount = new LottoCount();
        int lottoQuantity = lottoCount.calculateLottoCount(purchaseAmount);

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<List<Integer>> allUserLottoNumbers = lottoGenerator.generateLottoNumbers(lottoQuantity);

        LottoOutput lottoOutput = new LottoOutput();
        lottoOutput.printLottoCount(lottoQuantity);
        lottoOutput.printUserLottoNumbers(allUserLottoNumbers);

        List<Integer> winningNumbers = userInput.readWinningNumbers();
        int bonusNumber = userInput.readBonusNumber();

        LottoMatcher lottoMatcher = new LottoMatcher();
        LottoProfit lottoProfit = new LottoProfit(purchaseAmount);

        for (List<Integer> userLottoNumbers : allUserLottoNumbers) {
            lottoMatcher.checkLotto(winningNumbers, userLottoNumbers, bonusNumber);
            int matchCount = lottoMatcher.getMatchCounts()[4]; // 6개 일치
            lottoProfit.addPrize(matchCount, LottoRank.FIRST);
        }

        lottoOutput.printResults(lottoMatcher, lottoProfit);
    }
}
