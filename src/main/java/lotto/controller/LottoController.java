package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.service.LottoService;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();
    private final Validator validator = new Validator();


    public void run() {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottos = createLottos(purchaseAmount);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        Map<LottoRank, Integer> winningStats = lottoService.calculateWinningStats(lottos, winningNumbers, bonusNumber);
        double yield = lottoService.calculateYield(winningStats, purchaseAmount);

        printResults(lottos, winningStats, yield);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                String inputPurchaseAmount = inputView.inputPurchaseAmount();
                return Integer.parseInt(inputPurchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> createLottos(int purchaseAmount) {
        List<Lotto> lottos = lottoService.createLottos(purchaseAmount);
        outputView.printLottos(lottos);
        return lottos;
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                return inputView.inputLottoNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String inputBonusNumber = inputView.inputBonusNumber();
                validator.validateInputBonusNumber(inputBonusNumber, winningNumbers);
                return Integer.parseInt(inputBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printResults(List<Lotto> lottos, Map<LottoRank, Integer> winningStats, double yield) {
        outputView.printWinningStats(winningStats);
        outputView.printYield(yield);
    }

}
