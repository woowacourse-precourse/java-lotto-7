package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoGenerator lottoGenerator = new LottoGenerator();
        OutputView outputView = new OutputView();
        LottoProcessor lottoProcessor = new LottoProcessor();

        int purchaseAmount = inputView.readPurchaseAmount();
        int purchaseCount = purchaseAmount / 1000;

        outputView.printPurchaseNumber(purchaseAmount);
        List<List<Integer>> purchaseLottoNumbers = lottoGenerator.generate(purchaseCount);

        outputView.PrintPurchaseHistory(purchaseLottoNumbers);
        List<Integer> inputWinningNumbers = inputView.readWinningNumbers();

        int inputBonusNumber = inputView.readBonusNumber();

        Lotto lotto = new Lotto(inputWinningNumbers);

        Map<LottoType, Integer> lottoPickResult = lottoProcessor.lottoPick(purchaseLottoNumbers, lotto, inputBonusNumber);
        outputView.printWinningStatistics(lottoPickResult);

        outputView.printTotalReturn(lottoProcessor, purchaseAmount);
        Console.close();
    }
}
