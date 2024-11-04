package lotto.controller;

import static lotto.enums.Constants.PURCHASE_AMOUNT_UNIT;
import static lotto.enums.Constants.ZERO_VALUE;
import static lotto.util.Validator.validateBonusNumber;
import static lotto.util.Validator.validatePurchaseAmount;
import static lotto.util.Validator.validateWinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.enums.Rank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        generateAndDisplayLottos(purchaseAmount);
        calculateAndPrintResults();
        displayProfitRate(purchaseAmount);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                String inputPurchaseAmount = inputView.inputPurchaseAmount();
                return validatePurchaseAmount(inputPurchaseAmount);
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private void generateAndDisplayLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / PURCHASE_AMOUNT_UNIT.getValue();
        lottoService.generateLottos(lottoCount);
        outputView.printLottoCount(lottoCount);

        List<Lotto> lottos = lottoService.getLottos();
        lottos.forEach(lotto -> outputView.printLottoNumbers(lotto.getNumbers()));
    }

    private void calculateAndPrintResults() {
        List<Integer> winningNumbers = getWinningNumbers();
        lottoService.saveLottoRanks(winningNumbers, getBonusNumber(winningNumbers));
        Map<Rank, Integer> results = lottoService.getResults();

        outputView.printWinningStatisticsHeader();
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> printResults(rank, results));
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = inputView.inputWinningNumbers();
                return validateWinningNumbers(inputWinningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String inputBonusNumber = inputView.inputBonusNumber();
                return validateBonusNumber(winningNumbers, inputBonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private void printResults(Rank rank, Map<Rank, Integer> results) {
        int matchCount = rank.getMatchCount();
        int winningAmount = rank.getWinningAmount();
        int winningCount = results.getOrDefault(rank, ZERO_VALUE.getValue());

        if (rank.isRequiresBonus()) {
            outputView.printMatchWithBonusResult(matchCount, winningAmount, winningCount);
            return;
        }
        outputView.printMatchResult(matchCount, winningAmount, winningCount);
    }

    private void displayProfitRate(int purchaseAmount) {
        long winningAmount = lottoService.calculateWinningAmount();
        double profitRate = lottoService.calculateProfitRate(winningAmount, purchaseAmount);
        outputView.printProfitRate(profitRate);
    }
}
