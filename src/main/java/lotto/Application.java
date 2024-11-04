package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        LottoGenerator lottoGenerator = new LottoGenerator();

        int amount = inputHandler.getLottoAmount();
        List<Lotto> randomGeneratedLotto = lottoGenerator.lottoGenerator(amount);
        outputHandler.printPurchasedLotto(amount,randomGeneratedLotto);

        List<Integer> winnerNumbers = inputHandler.getWinnerNumber();
        int bonusNumber = inputHandler.getBonusNumber(winnerNumbers);

        LottoRankEvaluator lottoRankEvaluator = new LottoRankEvaluator(randomGeneratedLotto,winnerNumbers,bonusNumber);
        outputHandler.printResult(lottoRankEvaluator.getRankCount(),lottoRankEvaluator.getRateOfReturn());
    }
}
