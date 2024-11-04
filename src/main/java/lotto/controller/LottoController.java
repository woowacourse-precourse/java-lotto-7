package lotto.controller;

import lotto.dto.LottosDto;
import lotto.dto.WinningResultDto;
import lotto.model.*;
import lotto.util.WinningNumbersParser;

import java.util.List;

import static lotto.model.LottoProfitRateCalculator.calculateProfitRate;
import static lotto.view.InputView.*;
import static lotto.view.OuputView.*;

public class LottoController {

    public void run() {
        Cost cost = requestLottoCost();
        displayNewLine();

        Lottos lottos = createAndDisplayLottos(cost);

        WinningNumbers winningNumbers = requestWinningNumbers();
        displayNewLine();

        BonusNumber bonusNumber = requestBonusNumber(winningNumbers);
        displayNewLine();

        WinningResult winningResult = checkAndDisplayWinningResult(lottos, new DrawnNumbers(winningNumbers, bonusNumber));

        calculateAndDisplayProfitRate(cost, winningResult);
    }


    private Cost requestLottoCost() {
        displayLottoCostPrompt();
        while (true) {
            try {
                String costValue = inputLottoCost();
                return new Cost(costValue);
            } catch (IllegalArgumentException e) {
                displayExceptionMessage(e.getMessage());
            }
        }
    }

    private Lottos createAndDisplayLottos(Cost cost) {
        Lottos lottos = LottoFactory.generateLottos(cost);
        displayLottos(LottosDto.from(lottos));
        displayNewLine();
        return lottos;
    }

    private WinningNumbers requestWinningNumbers() {
        displayWinningNumbersPrompt();
        while (true) {
            try {
                String numbersValue = inputWinningNumbers();
                List<Integer> numbers = WinningNumbersParser.parse(numbersValue);
                return WinningNumbers.from(numbers);
            } catch (IllegalArgumentException e) {
                displayExceptionMessage(e.getMessage());
            }
        }
    }

    private BonusNumber requestBonusNumber(WinningNumbers winningNumbers) {
        displayBonusNumberPrompt();
        while (true) {
            try {
                String numberValue = inputBonusNumber();
                return new BonusNumber(numberValue, winningNumbers);
            } catch (IllegalArgumentException e) {
                displayExceptionMessage(e.getMessage());
            }
        }
    }

    private WinningResult checkAndDisplayWinningResult(Lottos lottos, DrawnNumbers drawnNumbers) {
        LottoResultChecker lottoResultChecker = new LottoResultChecker(drawnNumbers);
        WinningResult winningResult = lottoResultChecker.check(lottos);
        displayWinningResult(new WinningResultDto(winningResult));
        return winningResult;
    }

    private void calculateAndDisplayProfitRate(Cost cost, WinningResult winningResult) {
        double profitRate = calculateProfitRate(cost, winningResult);
        displayLottoProfitRate(profitRate);
    }
}
