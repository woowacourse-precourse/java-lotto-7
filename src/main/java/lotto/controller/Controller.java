package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.InputValidator;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final LottoService lottoService;
    private final InputValidator inputValidator;

    public Controller() {
        this.lottoService = new LottoService();
        this.inputValidator = new InputValidator();
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottoTickets = purchaseLottos(purchaseAmount);
        OutputView.printLottos(lottoTickets);

        Lotto winningLotto = getWinningLotto();
        int bonusLottoNumber = getBonusNumber(winningLotto);

        Map<LottoRank, Integer> lottoStatistics = lottoService.calculateStatistics(lottoTickets, winningLotto, bonusLottoNumber);
        OutputView.printWinningStatistics(lottoStatistics);

        displayFinalResult(lottoStatistics, purchaseAmount);
    }

    private void displayFinalResult(Map<LottoRank, Integer> lottoStatistics, int purchaseAmount) {
        long totalPrize = lottoService.calculateTotalPrize(lottoStatistics);
        double rateOfReturn = lottoService.calculateRateOfReturn(totalPrize, purchaseAmount);
        OutputView.printRateOfReturn(rateOfReturn);
    }

    private List<Lotto> purchaseLottos(int purchaseAmount) {
        int lottoCount = lottoService.calculateLottoCount(purchaseAmount);
        return lottoService.generateLottos(lottoCount);
    }

    private int getPurchaseAmount() {
        while (true) {
            String input = InputView.readPurchaseAmount();
            try {
                inputValidator.validatePurchaseAmount(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Lotto getWinningLotto() {
        while (true) {
            String input = InputView.readWinningNumbers();
            try {
                List<Integer> winningNumbers = parseWinningNumbers(input);
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int getBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String input = InputView.readBonusNumber();
                return inputValidator.validateBonusNumber(input, winningLotto);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}