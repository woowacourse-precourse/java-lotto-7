package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.ApplicationConfiguration;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration();
        InputView inputView = applicationConfiguration.inputView();
        OutputView outputView = applicationConfiguration.outputView();
        LottoProcessor lottoProcessor = applicationConfiguration.lottoProcessor();

        int purchaseAmount = inputView.readPurchaseAmount();
        int purchaseCount = purchaseAmount / 1000;

        outputView.printPurchaseNumber(purchaseAmount);
        List<List<Integer>> purchaseLottoNumbers = LottoUtils.generate(purchaseCount);

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
