package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGrade;
import lotto.model.LottoResult;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final InputService inputService = new InputService();
    private final LottoService lottoService = new LottoService();
    private final OutputView outputView = new OutputView();

    public void run() {
        int lottoCost = inputLottoCost();
        List<Lotto> lottos = generateLottos(lottoCost);
        Lotto winningLotto = inputWinningLotto();
        int bonusNumber = inputBonusNumber(winningLotto);

        LottoResult lottoResult = calculateTotalLottoResults(lottos, winningLotto, bonusNumber);
        double rateOfReturn = calculateRateOfReturn(lottoResult, lottoCost);
        displayLottoResult(lottoResult, rateOfReturn);
    }

    private int inputLottoCost() {
        while (true) {
            try {
                String lottoCost = inputView.inputLottoCost();
                return inputService.validateLottoCost(lottoCost);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> generateLottos(int cost) {
        List<Lotto> lottery = new ArrayList<>();
        int lottoCount = inputService.calculateLottoCount(cost);
        outputView.printLottoCountOutput(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = lottoService.makeLottoNumber();
            Lotto lotto = new Lotto(lottoNumbers);
            lottery.add(lotto);
            outputView.printLottoOutput(lottoNumbers);
        }

        return lottery;
    }

    private Lotto inputWinningLotto() {
        while (true) {
            try {
                String winningNumbers = inputView.inputWinningNumber();
                List<Integer> winningLottoNumbers = inputService.extractWinningNumbers(winningNumbers);
                return new Lotto(winningLottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputBonusNumber(Lotto winningLottery) {
        while (true) {
            try {
                return inputService.validateBonusNumber(winningLottery.getNumbers(),
                        inputView.inputBonusNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoResult calculateTotalLottoResults(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            LottoGrade lottoGrade = lottoService.checkLottoGrade(lotto, winningLotto, bonusNumber);
            lottoResult.addGrade(lottoGrade);
        }
        return lottoResult;
    }

    private double calculateRateOfReturn(LottoResult lottoResult, int cost) {
        int lottoReturn = lottoService.sumLottoPrize(lottoResult);
        return lottoService.calculateRateOfReturn(lottoReturn, cost);
    }

    private void displayLottoResult(LottoResult lottoResult, double rateOfReturn) {
        outputView.printTotalWinningResult(lottoResult);
        outputView.printRateOfReturn(rateOfReturn);
    }

}
