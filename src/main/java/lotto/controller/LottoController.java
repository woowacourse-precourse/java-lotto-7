package lotto.controller;

import java.util.List;
import lotto.dto.LottoControllerInputDto;
import lotto.dto.ProfitStatisticsDto;
import lotto.entity.LottoMachine;
import lotto.entity.ProfitReport;
import lotto.seirvce.LottoService;
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
        ProfitStatisticsDto profitStatisticsDto = new ProfitStatisticsDto.Builder()
                .prizeCount(profitReport.calculateWinningCountsByPrize())
                .profitRate(profitReport.calculateProfitRate()).build();
        consoleOutput.printPurchasedLottos(lottoMachine.getPurchasedLottos());
        consoleOutput.printProfitStatistics(profitStatisticsDto);
    }

    private LottoControllerInputDto getUserInputs() {
        InputRetryUtil inputRetryUtil = new InputRetryUtil(consoleInput, consoleOutput);
        int purchaseAmount = inputRetryUtil.getValidatedPurchaseAmount();
        List<Integer> winningNumbers = inputRetryUtil.getValidatedWinningNumbers();
        int bonusNumber = inputRetryUtil.getValidatedBonusNumber(winningNumbers);

        return new LottoControllerInputDto.Builder()
                .paymentAmount(purchaseAmount)
                .winnerNumbers(winningNumbers)
                .bonusNumber(bonusNumber)
                .build();
    }

}
