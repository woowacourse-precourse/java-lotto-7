package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.enums.ErrorMessage;
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
        outputHandler.printOK(money / 1000);
        List<Lotto> lottoIns = lottoService.lottoIssuance(money);
        outputHandler.printLottoS(lottoIns);

        List<Integer> numbers = inputNumberHandler();

        int bonusNum = inputBonusHandler();

        Map<PrizeAmount, Integer> lottoWinnings = lottoService.lottoWinning(lottoIns, numbers, bonusNum);
        Double returnRate = incomeService.rateOfReturn(money, lottoWinnings);

        outputHandle(lottoWinnings, returnRate);
    }

    public int inputMoneyHandler() {
        while (true) {
            try {
                String inputMoney = inputHandler.getInputMoney();
                int money = inputParser.parseMoney(inputMoney);

                validateService.validateMoney(money);
                return money;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputNumberHandler() {
        while(true) {
            try {
                List<Integer> numbers = inputParser.parseNumbers(inputHandler.getInputNums());
                Lotto lotto = new Lotto(numbers);

                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusHandler() {
        while(true) {
            try {
                int bonusNum = inputParser.parseBonus(inputHandler.getInputBonusNums());
                validateService.validateBonus(bonusNum);

                return bonusNum;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void outputHandle(Map<PrizeAmount, Integer> prizeAmounts, Double rate) {
        outputHandler.printWinning(prizeAmounts);
        outputHandler.printRateOfReturn(rate);
    }

}
