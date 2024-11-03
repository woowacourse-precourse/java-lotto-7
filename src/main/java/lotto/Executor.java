package lotto;

import java.util.List;

public class Executor {
    IOController ioController;
    Validator validator;
    Parser parser;

    Executor(IOController ioController, Validator validator, Parser parser) {
        this.ioController = ioController;
        this.validator = validator;
        this.parser = parser;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();

        // 구입금액만큼 lotto 생성 후 출력
        int purchaseCount = purchaseAmount / 1000;
        Lottos issuedLottos = Lottos.generateLottosByCount(purchaseCount);
        ioController.printLottos(issuedLottos.getLottos());

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);

        WinningStatisticsDto winningStatisticsDto = issuedLottos.calculateWinningResults(winningLotto);
        ioController.printWinningResults(winningStatisticsDto.getWinningStatistics());

        double lottoYield = winningStatisticsDto.getLottoYield(purchaseAmount);
        ioController.printWinningStatistics(lottoYield);

    }

    private int getPurchaseAmount() {
        String purchaseAmountInput;
        while (true) {
            try {
                purchaseAmountInput = ioController.inputPurchaseAmount();
                validator.validatePurchaseAmount(purchaseAmountInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return parser.parsePurchaseAmount(purchaseAmountInput);
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        String bonusNumberInput;
        while (true) {
            try {
                bonusNumberInput = ioController.inputBonusNumber();
                validator.validateBonusNumber(bonusNumberInput, winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return parser.parseBonusNumber(bonusNumberInput);
    }

    private List<Integer> getWinningNumbers() {
        String winningNumbersInput;
        while (true) {
            try {
                winningNumbersInput = ioController.inputWinningNumbers();
                validator.validateWinningNumbers(winningNumbersInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return parser.parseWinningNumbers(winningNumbersInput);
    }
}
