package lotto.controller;

import java.util.List;
import lotto.dto.ProfitStatisticsDto;
import lotto.entity.LottoMachine;
import lotto.entity.ProfitReport;
import lotto.validator.LottoValidator;
import lotto.validator.PurchaseValidator;
import lotto.validator.WinningNumbersValidator;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class LottoController {
    final private ConsoleInput consoleInput;
    final private ConsoleOutput consoleOutput;

    public LottoController(ConsoleInput consoleInput, ConsoleOutput consoleOutput) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
    }


    public void run() {
        int paymentAmount;
        List<Integer> numbers;
        int bonusNumber;

        while (true) {
            try {
                String userInput = consoleInput.getPurchasedAmount();
                paymentAmount = InputParser.parseInteger(userInput);
                PurchaseValidator.validate(paymentAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        while (true) {
            try {
                String userInput = consoleInput.getWinningNumbers();
                numbers = InputParser.parseIntegers(userInput);
                LottoValidator.validate(numbers);
                break;
            } catch (Exception e) {
                System.err.println("[ERROR] " + e.getMessage());
            }
        }

        while (true) {
            try {
                String input = consoleInput.getBonusNumber();
                bonusNumber = InputParser.parseInteger(input);
                WinningNumbersValidator.bonusNumber(numbers, bonusNumber);
                break;
            } catch (Exception e) {
                System.err.println("[ERROR] " + e.getMessage());
            }
        }

        LottoMachine lottoMachine = new LottoMachine(paymentAmount, numbers, bonusNumber);
        ProfitReport profitReport = new ProfitReport(lottoMachine.getPurchasedLottos(),
                lottoMachine.getWinningNumbers());

        consoleOutput.printPurchasedLottos(lottoMachine.getPurchasedLottos());

        ProfitStatisticsDto dto = new ProfitStatisticsDto(
                profitReport.calculateWinningCountsByRank(), profitReport.calculateProfitRate()
        );
        consoleOutput.printProfitStatistics(dto);
    }
}
