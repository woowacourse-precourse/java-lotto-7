package lotto;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final InputHandler inputHandler;
    private final InputParser inputParser;
    private final OutputHandler outputHandler;
    private final LottoGenerator lottoGenerator;
    private final LottoResultChecker resultChecker;
    private final LottoStatistics statistics;

    public LottoController() {
        inputHandler = new InputHandler();
        inputParser = new InputParser(new InputValidate());
        outputHandler = new OutputHandler();
        lottoGenerator = new LottoGenerator();
        resultChecker = new LottoResultChecker();
        statistics = new LottoStatistics();
    }

    public void run() {
        int purchaseAmount = inputParser.parsePurchaseAmount(inputHandler.getPurchaseAmount());
        List<Lotto> lottos = lottoGenerator.generateLottos(purchaseAmount);
        outputHandler.printLottoNumbers(lottos.size(), lottos.stream().map(Lotto::getNumbers).toList());

        List<Integer> winningNumbers = inputParser.parseWinningNumbers(inputHandler.getWinningNumbers());
        int bonusNumber = inputParser.parseBonusNumber(inputHandler.getBonusNumber(), winningNumbers);

        Map<WinningRank, Integer> results = resultChecker.checkResults(lottos, winningNumbers, bonusNumber);
        outputHandler.printWinningStatistics(results);

        double yield = statistics.calculateYield(results, purchaseAmount);
        outputHandler.printYield(yield);
    }
}
