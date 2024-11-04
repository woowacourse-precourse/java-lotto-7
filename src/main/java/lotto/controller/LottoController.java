package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoEvaluator;
import lotto.model.LottoGenerator;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private LottoGenerator lottoGenerator;
    private LottoEvaluator lottoEvaluator;
    private Validator validator;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        validator = new Validator();
        int purchaseAmount = validatePurchaseAmount();

        lottoGenerator = new LottoGenerator(purchaseAmount / 1000);
        List<Lotto> lottos = lottoGenerator.generateLottos();
        outputView.displayLottoCount(lottoGenerator.getLottoCnt());
        outputView.displayLottos(lottos);

        Lotto winningLotto = validateWinningNumbers();
        int bonusNum = validateBonusNumber(winningLotto);

        lottoEvaluator = new LottoEvaluator(purchaseAmount, lottos, winningLotto, bonusNum);

        lottoEvaluator.evaluateResult();
        lottoEvaluator.calculateProfit();
        outputView.displayResults(lottoEvaluator.getLottoStats(), lottoEvaluator.getProfitRate());
    }

    public int validatePurchaseAmount() {
        int purchaseAmount = 0;
        while (true) {
            try {
                purchaseAmount = inputView.getPurchaseAmount();
                validator.validatePositiveAmount(purchaseAmount);
                validator.validateAmountUnit(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    public Lotto validateWinningNumbers() {
        List<Integer> winningNumbers;
        Lotto winningLotto;
        while (true) {
            try {
                winningNumbers = inputView.getWinningNumbers();
                winningLotto = new Lotto(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningLotto;
    }

    public int validateBonusNumber(Lotto winningLotto) {
        int bonusNum = 0;
        while (true) {
            try {
                bonusNum = inputView.getBonusNumber();
                validator.validateBonusRange(bonusNum);
                validator.validateBonusDuplicate(winningLotto.getNumbers(), bonusNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNum;
    }
}