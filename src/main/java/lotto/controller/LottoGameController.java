package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningResult;
import lotto.model.constant.ErrorMessage;
import lotto.service.LottoEvaluator;
import lotto.service.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;
    private final LottoEvaluator lottoEvaluator;

    public LottoGameController(InputView inputView, OutputView outputView, LottoGenerator lottoGenerator,
                               LottoEvaluator lottoEvaluator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = lottoGenerator;
        this.lottoEvaluator = lottoEvaluator;
    }

    public void run() {
        int lottoPurchaseAmount = 0;

        while (true) {
            try {
                inputView.displayLottoPurchaseAmountPrompt();
                lottoPurchaseAmount = parseLottoPurchaseAmount(inputView.readLottoPurchaseAmount());
                validateMultipleOf1000(lottoPurchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }

        Lottos lottos = Lottos.from(lottoGenerator.issue(lottoPurchaseAmount));
        outputView.displayLottoCount(lottos);
        outputView.displayLottoNumbers(lottos);

        List<Integer> parsedWinningNumbers;
        WinningNumbers winningNumbers;

        while (true) {
            try {
                inputView.displayWinningNumbersPrompt();
                parsedWinningNumbers = parseWinningNumbers(inputView.readWinningNumbers());
                winningNumbers = WinningNumbers.from(parsedWinningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }

        inputView.displayBonusNumberPrompt();
        int parsedBonusNumber = parseLottoNumber(inputView.readBonusNumber());
        BonusNumber bonusNumber = new BonusNumber(parsedBonusNumber);

        Map<WinningResult, Integer> winningResults = lottoEvaluator.evaluateWinningResult(lottos, winningNumbers,
                bonusNumber);
        outputView.displayWinningResult(winningResults);

        double profitRate = lottoEvaluator.evaluateProfitRate(winningResults, lottoPurchaseAmount);
        outputView.displayProfitRate(profitRate);
    }

    private List<Integer> parseWinningNumbers(String userInput) {
        List<Integer> numbers = new ArrayList<>();
        String[] userInputNumbers = userInput.split(",", -1);

        for (String userInputNumber : userInputNumbers) {
            int number = parseLottoNumber(userInputNumber.trim());
            numbers.add(number);
        }

        return numbers;
    }

    private int parseLottoNumber(String userInputNumber) {
        return parseNumber(userInputNumber, ErrorMessage.INVALID_LOTTO_NUMBER_FORMAT);
    }

    private int parseLottoPurchaseAmount(String userInputNumber) {
        return parseNumber(userInputNumber, ErrorMessage.INVALID_PURCHASE_AMOUNT_FORMAT);
    }

    private int parseNumber(String userInputNumber, String errorMessage) {
        try {
            return Integer.parseInt(userInputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateMultipleOf1000(int lottoPurchaseAmount) {
        if (lottoPurchaseAmount == 0 || lottoPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MULTIPLE_OF_1000);
        }
    }
}
