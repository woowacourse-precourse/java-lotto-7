package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Buy;
import lotto.domain.Lotto;
import lotto.domain.LottoBonus;
import lotto.domain.LottoCalculate;
import lotto.domain.LottoRandom;
import lotto.domain.LottoResult;
import lotto.global.LottoScore;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startLottoGame() {
        Buy buy = buyLotto();
        printLottoCounts(buy);

        List<Lotto> randomLottoNumbers = printLottoRandomNumbers(buy.getLottoCounts());

        Lotto lotto = inputWinningLottoNumbers();
        LottoBonus lottoBonus = inputBonusLottoNumber(lotto.getNumbers());

        List<LottoScore> lottoScores = calculateLotto(lotto.getNumbers(), randomLottoNumbers,
                lottoBonus.getBonusNumber());

        printLottoResult(lottoScores, buy.getMoney());
    }

    private Buy buyLotto() {
        return inputView.buyLotto();
    }

    private void printLottoCounts(Buy buy) {
        buy.calculateLottoCounts();
        outputView.printTotalLottoCounts(buy.getLottoCounts());
    }

    private List<Lotto> printLottoRandomNumbers(int lottoCounts) {
        LottoRandom lottoRandom = new LottoRandom();
        List<Lotto> lottos = lottoRandom.generateLottoRandom(lottoCounts);
        outputView.printLottoRandomNumber(lottos);

        return lottos;
    }

    private Lotto inputWinningLottoNumbers() {
        return inputView.inputWinningLottoNumbers();
    }

    private LottoBonus inputBonusLottoNumber(List<Integer> numbers) {
        return inputView.inputLottoBonusNumber(numbers);
    }

    private List<LottoScore> calculateLotto(List<Integer> winningLottoNumber, List<Lotto> randomLottoNumbers,
                                            int bonusNumber) {
        LottoCalculate lottoCalculate = new LottoCalculate();

        lottoCalculate.calculateLottoNumbers(winningLottoNumber, randomLottoNumbers, bonusNumber);

        return lottoCalculate.getLottoScores();
    }

    private void printLottoResult(List<LottoScore> lottoScores, int money) {
        LottoResult lottoResult = new LottoResult();
        Map<LottoScore, Integer> lottoScoreIntegerated = lottoResult.integrateLottoScore(lottoScores);
        lottoResult.deleteNoPrize();
        double lottoProfit = lottoResult.calculateLottoProfit(money);

        outputView.printLottoResult(lottoScoreIntegerated);
        outputView.printLottoProfit(lottoProfit);
    }
}
