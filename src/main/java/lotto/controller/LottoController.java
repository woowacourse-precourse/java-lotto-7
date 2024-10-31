package lotto.controller;

import java.util.List;
import java.util.Set;
import lotto.enums.PrizeAmount;
import lotto.model.Lotto;
import lotto.parser.InputParser;
import lotto.service.IncomeService;
import lotto.service.LottoService;
import lotto.service.ValidateService;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class LottoController {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final InputParser inputParser;
    private final ValidateService validateService;
    private final LottoService lottoService;
    private  final IncomeService incomeService;

    public LottoController(InputHandler inputHandler, OutputHandler outputHandler, InputParser inputParser, ValidateService validateService,
                           LottoService lottoService, IncomeService incomeService) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.inputParser = inputParser;
        this.validateService = validateService;
        this.lottoService = lottoService;
        this.incomeService = incomeService;
    }

    public void run() {
        // 1. 돈 입력 받고 유효하면 몇개 구매 했는지 출력, 발행 번호도 출력
        int money = inputMoneyHandler();
        outputHandler.printLottoS(lottoService.lottoIssuance(money));

        String[] result = inputHandle();
        List<Integer> numbers = inputParser.parseNumbers(result[0]);
        int bonusNum = inputParser.parseBonus(result[1]);

        if (!validationCheck(numbers, bonusNum)) { return; }

        Set<PrizeAmount> lottoWinnings = lottoService.lottoWinning(lottoService.lottoIssuance(money), numbers, bonusNum);
        Double returnRate = incomeService.rateOfReturn(money, lottoWinnings);

        outputHandle(lottoWinnings, returnRate);
    }

    public int inputMoneyHandler() {
        String input_money = inputHandler.getInputMoney();
        int money = inputParser.parseMoney(input_money);
        if (validateService.validateMoney(money)){
            return money;
        }
        return 0;
    }

    public String[] inputHandle() {
        String[] result = new String[2];
        result[0] = inputHandler.getInputNums();
        result[1] = inputHandler.getInputBonusNums();
        return result;
    }

    public void outputHandle(Set<PrizeAmount> prizeAmounts, Double rate) {
        outputHandler.printWinning(prizeAmounts);
        outputHandler.printRateOfReturn(rate);
    }

    public boolean validationCheck(List<Integer> numbers, int bonusNum) {
        if (validateService.validateRangeLottoNumbers(numbers)
            && validateService.validateDuplicateLottoNumbers(numbers)
            && validateService.validateBonus(bonusNum)) {
            return true;
        }
        return false;
    }

}
