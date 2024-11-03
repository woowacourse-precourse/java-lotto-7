package lotto.controller;

import java.util.List;
import lotto.dto.LottoControllerInputDto;
import lotto.dto.ProfitStatisticsDto;
import lotto.entity.Lotto;
import lotto.entity.LottoMachine;
import lotto.entity.ProfitReport;
import lotto.seirvce.LottoService;
import lotto.validator.LottoValidator;
import lotto.validator.PurchaseValidator;
import lotto.validator.WinningNumbersValidator;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class LottoController {
    final private ConsoleInput consoleInput;
    final private ConsoleOutput consoleOutput;
    final private LottoService lottoService;

    public LottoController(ConsoleInput consoleInput, ConsoleOutput consoleOutput, LottoService lottoService) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
        this.lottoService = lottoService;
    }


    public void run() {
        // input
        LottoControllerInputDto inputDto = getUserInputs();

        // business logic
        LottoMachine lottoMachine = lottoService.createLottoMachine(inputDto);
        ProfitReport profitReport = lottoService.generateProfitReport(lottoMachine);

        // output
        ProfitStatisticsDto profitStatisticsDto = new ProfitStatisticsDto(profitReport.calculateWinningCountsByPrize(),
                profitReport.calculateProfitRate());

        consoleOutput.printPurchasedLottos(lottoMachine.getPurchasedLottos());
        consoleOutput.printProfitStatistics(profitStatisticsDto);
    }

    private void displayLottoResults(List<Lotto> purchaseLottos, ProfitStatisticsDto dto) {
        consoleOutput.printPurchasedLottos(purchaseLottos);
        consoleOutput.printProfitStatistics(dto);
    }

    private LottoControllerInputDto getUserInputs() {
        int purchaseAmount = getPurchaseAmount();
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        return new LottoControllerInputDto.Builder()
                .paymentAmount(purchaseAmount)
                .winnerNumbers(winningNumbers)
                .bonusNumber(bonusNumber)
                .build();
    }

    private int getPurchaseAmount() {
        int paymentAmount;

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
        return paymentAmount;
    }

    private List<Integer> getWinningNumbers() {
        List<Integer> numbers;

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
        return numbers;
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;

        while (true) {
            try {
                String input = consoleInput.getBonusNumber();
                bonusNumber = InputParser.parseInteger(input);
                WinningNumbersValidator.bonusNumber(winningNumbers, bonusNumber);
                break;
            } catch (Exception e) {
                System.err.println("[ERROR] " + e.getMessage());
            }
        }
        return bonusNumber;
    }

}
