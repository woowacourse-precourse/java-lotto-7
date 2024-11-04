package lotto;

import java.util.List;
import lotto.io.InputMessage;
import lotto.io.InputReader;
import lotto.io.OutputPrinter;

public class LottoApplication {

    private final InputReader inputReader;
    private final OutputPrinter outputPrinter;
    private final LottoGenerator lottoGenerator;

    public LottoApplication() {
        this.inputReader = new InputReader();
        this.outputPrinter = new OutputPrinter();
        this.lottoGenerator = new LottoGenerator();
    }

    public void run() {
        List<Lotto> lottos = purchaseLotto();
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        Result result = getResult(lottos, winningNumbers, bonusNumber);

        outputPrinter.printResult(result);
    }

    private List<Lotto> purchaseLotto() {
        InputMessage.purchaseAmount();
        long purchaseAmount = inputReader.readPurchaseAmount();
        List<Lotto> lottos = lottoGenerator.purchase(purchaseAmount);
        outputPrinter.printLottoCreated(lottos);

        return lottos;
    }

    private List<Integer> getWinningNumbers() {
        InputMessage.winningNumbers();
        return inputReader.readWinningNumbers();
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        InputMessage.bonusNumber();
        return inputReader.readBonusNumber(winningNumbers);
    }

    private Result getResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Calculator calculator = new Calculator(lottos, winningNumbers, bonusNumber);
        return calculator.calculateResult();
    }
}
